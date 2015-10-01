package com.dbsl.proposalgenerator.gui.admin.wizard.employee;

import org.vaadin.teemu.wizards.WizardStep;

import com.vaadin.data.fieldgroup.FieldGroup;
import com.vaadin.data.fieldgroup.FieldGroup.CommitException;
import com.vaadin.server.ThemeResource;
import com.vaadin.shared.ui.label.ContentMode;
import com.vaadin.ui.Component;
import com.vaadin.ui.Embedded;
import com.vaadin.ui.Label;
import com.vaadin.ui.VerticalLayout;

public class AddEmpDetailStep implements WizardStep {

    FieldGroup binder;
    EmployeeDetailForm addForm;

    public AddEmpDetailStep(FieldGroup binder) {
        this.binder = binder;
        addForm = new EmployeeDetailForm();
        binder.bindMemberFields(addForm);
    }

    @Override
    public String getCaption() {
        return "Add Emloyee Details";
    }

    @Override
    public Component getContent() {
        VerticalLayout content = new VerticalLayout();
        content.setSizeFull();
        content.setMargin(true);

        Label text = getText();
        content.addComponent(addForm);

        Embedded arrow = getArrow();
        // content.addComponent(arrow);

        return content;
    }

    private Label getText() {
        return new Label("<h2>Enter Employee Details</h2>", ContentMode.HTML);
    }

    private Embedded getArrow() {
        Embedded arrow = new Embedded("", new ThemeResource("img/arrow-down.png"));
        arrow.setStyleName("intro-arrow");
        return arrow;
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
