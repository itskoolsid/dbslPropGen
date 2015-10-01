package com.dbsl.proposalgenerator.gui.admin.wizard.employee;

import com.vaadin.ui.CustomComponent;
import com.vaadin.ui.FormLayout;
import com.vaadin.ui.TextField;

@SuppressWarnings("serial")
public class EmployeeAddressForm extends CustomComponent {
    private final TextField line1;
    private final TextField line2;
    private final TextField streetNo;
    private final TextField stateProvince;
    private final TextField zipCode;
    private final TextField country;

    public EmployeeAddressForm() {
        super();
        FormLayout form = new FormLayout();
        line1 = new TextField("Address Line#2");
        line2 = new TextField("Address Line#1");
        streetNo = new TextField("Street No.");
        stateProvince = new TextField("State/Province");
        zipCode = new TextField("Zip Code");
        country = new TextField("Country");

        line1.setNullRepresentation("");
        line2.setNullRepresentation("");
        streetNo.setNullRepresentation("");
        stateProvince.setNullRepresentation("");
        zipCode.setNullRepresentation("");
        country.setNullRepresentation("");

        form.addComponent(line1);
        form.addComponent(line2);
        form.addComponent(streetNo);
        form.addComponent(stateProvince);
        form.addComponent(zipCode);
        form.addComponent(country);
        setCompositionRoot(form);
    }

}
