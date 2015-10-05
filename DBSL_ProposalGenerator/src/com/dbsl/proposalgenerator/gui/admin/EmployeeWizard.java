package com.dbsl.proposalgenerator.gui.admin;

import java.util.Set;

import org.vaadin.alump.fancylayouts.FancyNotifications;
import org.vaadin.teemu.wizards.Wizard;
import org.vaadin.teemu.wizards.event.WizardCancelledEvent;
import org.vaadin.teemu.wizards.event.WizardCompletedEvent;
import org.vaadin.teemu.wizards.event.WizardProgressListener;
import org.vaadin.teemu.wizards.event.WizardStepActivationEvent;
import org.vaadin.teemu.wizards.event.WizardStepSetChangedEvent;

import com.dbsl.proposalgenerator.beans.Address;
import com.dbsl.proposalgenerator.beans.Contact;
import com.dbsl.proposalgenerator.beans.Employee;
import com.dbsl.proposalgenerator.beans.Privilege;
import com.dbsl.proposalgenerator.dao.EmployeeDAO;
import com.dbsl.proposalgenerator.dao.imp.EmployeeDAOImpl;
import com.dbsl.proposalgenerator.gui.admin.wizard.employee.AddEmpAddressStep;
import com.dbsl.proposalgenerator.gui.admin.wizard.employee.AddEmpContactStep;
import com.dbsl.proposalgenerator.gui.admin.wizard.employee.AddEmpDetailStep;
import com.dbsl.proposalgenerator.gui.admin.wizard.employee.AddEmpPrivilegeStep;
import com.vaadin.data.Item;
import com.vaadin.data.fieldgroup.FieldGroup;
import com.vaadin.data.util.BeanItem;
import com.vaadin.server.Page;
import com.vaadin.server.ThemeResource;
import com.vaadin.server.VaadinSession;
import com.vaadin.ui.Alignment;
import com.vaadin.ui.Button;
import com.vaadin.ui.Button.ClickEvent;
import com.vaadin.ui.Notification;
import com.vaadin.ui.VerticalLayout;

public class EmployeeWizard extends VerticalLayout implements
		WizardProgressListener {
	private final Wizard wizard;
	private final Employee employee;
	private final BeanItem<Employee> employeeItem;
	private EmployeeDAO empDAO;
	private final FancyNotifications notifications;

	public EmployeeWizard() {
		setSizeFull();
		setMargin(true);
		notifications = new FancyNotifications();

		empDAO = new EmployeeDAOImpl();
		wizard = new Wizard();
		wizard.setUriFragmentEnabled(false);
		wizard.addListener(this);
		employee = new Employee(new Contact(), new Address());
		employeeItem = new BeanItem<Employee>(employee);
		FieldGroup binder = new FieldGroup(employeeItem);
		Item contactItem = new BeanItem<Contact>(employee.getContact());
		Item addressItem = new BeanItem<Address>(employee.getAddress());
		Item privilegeItem = new BeanItem<Set<Privilege>>(
				employee.getPrivileges());
		FieldGroup conBinder = new FieldGroup(contactItem);
		FieldGroup addressBinder = new FieldGroup(addressItem);
		FieldGroup privilegeBinder = new FieldGroup(privilegeItem);
		wizard.addStep(new AddEmpDetailStep(binder), "empDetails");
		wizard.addStep(new AddEmpContactStep(conBinder), "empContact");
		wizard.addStep(new AddEmpAddressStep(addressBinder), "empAddress");
		wizard.addStep(new AddEmpPrivilegeStep(privilegeBinder, wizard),
				"empPrivilege");
		wizard.setSizeFull();
		addComponent(wizard);
		setComponentAlignment(wizard, Alignment.TOP_CENTER);
	}

	@Override
	public void wizardCompleted(WizardCompletedEvent event) {
		System.out.println("************ "
				+ employeeItem.getBean().getFirstName() + " :: "
				+ employeeItem.getBean().getContact().getMobNo()
				+ employeeItem.getBean().getAddress().getLine1());
		// empDAO.addEmployee(employeeItem.getBean());
		Employee e = empDAO.getEmployeeByName("Sidharth");
		System.out.println(e.getLastName());
		notifications.showNotification(this, "Vaadin", "http://www.vaadin.com",
				new ThemeResource("images/reindeer.png"));
		// endWizard("Wizard Completed!");
	}

	@Override
	public void activeStepChanged(WizardStepActivationEvent event) {
		// display the step caption as the window title
		Page.getCurrent().setTitle(event.getActivatedStep().getCaption());
	}

	@Override
	public void stepSetChanged(WizardStepSetChangedEvent event) {
		// NOP, not interested on this event
	}

	@Override
	public void wizardCancelled(WizardCancelledEvent event) {
		endWizard("Wizard Cancelled!");
	}

	private void endWizard(String message) {
		wizard.setVisible(false);
		Notification.show(message);
		Page.getCurrent().setTitle(message);
		Button startOverButton = new Button("Add another Employee",
				new Button.ClickListener() {
					@Override
					public void buttonClick(ClickEvent event) {
						// Close the session and reload the page.
						VaadinSession.getCurrent().close();
						Page.getCurrent().setLocation("");
					}
				});
		addComponent(startOverButton);
		setComponentAlignment(startOverButton, Alignment.MIDDLE_CENTER);
	}
}
