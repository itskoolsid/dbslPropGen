package com.dbsl.proposalgenerator.gui.admin;

import org.vaadin.teemu.wizards.Wizard;
import org.vaadin.teemu.wizards.event.WizardCancelledEvent;
import org.vaadin.teemu.wizards.event.WizardCompletedEvent;
import org.vaadin.teemu.wizards.event.WizardProgressListener;
import org.vaadin.teemu.wizards.event.WizardStepActivationEvent;
import org.vaadin.teemu.wizards.event.WizardStepSetChangedEvent;

import com.dbsl.proposalgenerator.beans.Address;
import com.dbsl.proposalgenerator.beans.Contact;
import com.dbsl.proposalgenerator.beans.Employee;
import com.dbsl.proposalgenerator.gui.admin.wizard.employee.AddEmpAddressStep;
import com.dbsl.proposalgenerator.gui.admin.wizard.employee.AddEmpContactStep;
import com.dbsl.proposalgenerator.gui.admin.wizard.employee.AddEmpDetailStep;
import com.dbsl.proposalgenerator.gui.admin.wizard.employee.AddEmpPrivilegeStep;
import com.vaadin.data.util.BeanItem;
import com.vaadin.server.Page;
import com.vaadin.server.VaadinSession;
import com.vaadin.ui.Alignment;
import com.vaadin.ui.Button;
import com.vaadin.ui.Button.ClickEvent;
import com.vaadin.ui.Notification;
import com.vaadin.ui.VerticalLayout;

public class EmployeeWizard extends VerticalLayout implements WizardProgressListener {
    private final Wizard wizard;
    private final Employee employee;
    private final BeanItem<Employee> employeeItem;

    public EmployeeWizard() {
        // setup the main window
        setSizeFull();
        setMargin(true);

        // create the Wizard component and add the steps
        wizard = new Wizard();
        wizard.setUriFragmentEnabled(true);
        wizard.addListener(this);
        employee = new Employee(new Contact(), new Address());
        employeeItem = new BeanItem<Employee>(employee); // item from
        wizard.addStep(new AddEmpDetailStep(employeeItem), "intro");
        wizard.addStep(new AddEmpContactStep(employeeItem), "setup");
        wizard.addStep(new AddEmpAddressStep(employeeItem), "listen");
        wizard.addStep(new AddEmpPrivilegeStep(employeeItem, wizard), "last");
        wizard.setSizeFull();
        addComponent(wizard);
        setComponentAlignment(wizard, Alignment.TOP_CENTER);
    }

    @Override
    public void wizardCompleted(WizardCompletedEvent event) {
        System.out.println("************ " + employeeItem.getBean().getFirsName() + " :: "
                + employeeItem.getBean().getContact().getMobNo());
        endWizard("Wizard Completed!");
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
        Button startOverButton = new Button("Run the demo again", new Button.ClickListener() {
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
