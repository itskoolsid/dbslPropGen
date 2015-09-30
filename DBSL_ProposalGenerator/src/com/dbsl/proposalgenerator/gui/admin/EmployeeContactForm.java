package com.dbsl.proposalgenerator.gui.admin;

import com.dbsl.proposalgenerator.beans.Contact;
import com.dbsl.proposalgenerator.beans.Employee;
import com.vaadin.data.fieldgroup.FieldGroup;
import com.vaadin.data.util.BeanItem;
import com.vaadin.ui.CustomComponent;
import com.vaadin.ui.FormLayout;
import com.vaadin.ui.TextField;

@SuppressWarnings("serial")
public class EmployeeContactForm extends CustomComponent {
    private final TextField mobNo;
    private final TextField homeNo;
    private final TextField officeNo1;
    private final TextField officeNo2;
    private final TextField emailId;
    private final TextField faxNo;
    BeanItem<Employee> employeeItem;

    public EmployeeContactForm(BeanItem<Employee> employeeItem) {
        super();
        this.employeeItem = employeeItem;
        mobNo = new TextField("Mobile No.");
        homeNo = new TextField("Landline No.");
        officeNo1 = new TextField("Office Tel#1");
        officeNo2 = new TextField("Office Tel#2");
        emailId = new TextField("Email ID");
        faxNo = new TextField("Fax No.");

        FormLayout layout = new FormLayout();
        layout.addComponent(mobNo);
        layout.addComponent(homeNo);
        layout.addComponent(officeNo1);
        layout.addComponent(officeNo2);
        layout.addComponent(emailId);
        layout.addComponent(faxNo);
        // Now use a binder to bind the members
        /*
         * employeeItem .addItemProperty("discoverername", new NestedMethodProperty<Contact>(employeeItem.getBean(),
         * "contact.mobNo"));
         */

        BeanItem<Contact> cont = new BeanItem<Contact>(employeeItem.getBean().getContact());
        FieldGroup binder = new FieldGroup(cont);
        binder.bindMemberFields(this);
        binder.setBuffered(true);

        setCompositionRoot(layout);
    }

}
