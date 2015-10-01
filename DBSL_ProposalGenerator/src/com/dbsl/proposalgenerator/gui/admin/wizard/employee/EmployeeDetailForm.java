package com.dbsl.proposalgenerator.gui.admin.wizard.employee;

import com.vaadin.ui.CustomComponent;
import com.vaadin.ui.FormLayout;
import com.vaadin.ui.TextField;

@SuppressWarnings("serial")
public class EmployeeDetailForm extends CustomComponent {
    // Member that will bind to the "name" property
    TextField firsName;
    TextField middleName;
    TextField lastName;
    TextField designation;
    TextField empCode;

    public EmployeeDetailForm() {
        FormLayout layout = new FormLayout();
        firsName = new TextField("Name");
        middleName = new TextField("Middle Name");
        lastName = new TextField("Last Name");
        designation = new TextField("Designation");
        empCode = new TextField("Employee Code");

        layout.addComponent(firsName);
        layout.addComponent(middleName);
        layout.addComponent(lastName);
        layout.addComponent(designation);
        layout.addComponent(empCode);

        firsName.setNullRepresentation("");
        middleName.setNullRepresentation("");
        lastName.setNullRepresentation("");
        designation.setNullRepresentation("");
        empCode.setNullRepresentation("");
        setCompositionRoot(layout);
    }

}
