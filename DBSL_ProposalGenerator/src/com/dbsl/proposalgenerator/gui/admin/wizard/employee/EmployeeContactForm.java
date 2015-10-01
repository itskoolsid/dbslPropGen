package com.dbsl.proposalgenerator.gui.admin.wizard.employee;

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

    public EmployeeContactForm() {
        super();
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
        mobNo.setNullRepresentation("");
        homeNo.setNullRepresentation("");
        officeNo1.setNullRepresentation("");
        officeNo2.setNullRepresentation("");
        emailId.setNullRepresentation("");
        faxNo.setNullRepresentation("");

        mobNo.setImmediate(true);
        setCompositionRoot(layout);
    }

}
