package com.dbsl.proposalgenerator.gui.admin;

import com.dbsl.proposalgenerator.beans.Employee;
import com.vaadin.data.fieldgroup.FieldGroup;
import com.vaadin.data.util.BeanItem;
import com.vaadin.ui.CustomComponent;
import com.vaadin.ui.FormLayout;
import com.vaadin.ui.TextField;

@SuppressWarnings("serial")
public class EmployeeForm extends CustomComponent {
    // Member that will bind to the "name" property
    TextField firsName = new TextField("Name");
    TextField middleName = new TextField("Middle Name");
    TextField lastName = new TextField("Last Name");
    TextField designation = new TextField("Designation");
    TextField empCode = new TextField("Employee Code");

    public EmployeeForm(BeanItem<Employee> employeeItem) {
        FormLayout layout = new FormLayout();
        layout.addComponent(firsName);
        layout.addComponent(middleName);
        layout.addComponent(lastName);
        layout.addComponent(designation);
        layout.addComponent(empCode);
        // Now use a binder to bind the members
        FieldGroup binder = new FieldGroup(employeeItem);
        binder.bindMemberFields(this);
        binder.setBuffered(true);
        setCompositionRoot(layout);
    }

}
