package com.dbsl.proposalgenerator.gui.admin.wizard.employee;

import org.vaadin.teemu.wizards.WizardStep;

import com.vaadin.data.fieldgroup.FieldGroup;
import com.vaadin.data.fieldgroup.FieldGroup.CommitException;
import com.vaadin.shared.ui.label.ContentMode;
import com.vaadin.ui.Component;
import com.vaadin.ui.Label;
import com.vaadin.ui.VerticalLayout;

public class AddEmpContactStep implements WizardStep {

    FieldGroup binder;
    EmployeeContactForm contactForm;

    public AddEmpContactStep(FieldGroup binder) {
        this.binder = binder;
        contactForm = new EmployeeContactForm();
        binder.bindMemberFields(contactForm);
    }

    @Override
    public String getCaption() {
        return "Add Contact Details";
    }

    @Override
    public Component getContent() {
        VerticalLayout content = new VerticalLayout();
        content.setSizeFull();
        content.setMargin(true);

        content.addComponent(contactForm);

        return content;
    }

    private Label getText() {
        return new Label("<h2>Initialize the Wizard</h2>", ContentMode.HTML);
    }

    @Override
    public boolean onAdvance() {
        try {
            binder.commit();
        } catch (CommitException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return true;
    }

    @Override
    public boolean onBack() {
        return true;
    }

}