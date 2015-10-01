package com.dbsl.proposalgenerator.gui.admin.wizard.employee;

import org.vaadin.teemu.wizards.Wizard;
import org.vaadin.teemu.wizards.WizardStep;

import com.vaadin.data.fieldgroup.FieldGroup;
import com.vaadin.data.util.IndexedContainer;
import com.vaadin.shared.ui.label.ContentMode;
import com.vaadin.ui.CheckBox;
import com.vaadin.ui.Component;
import com.vaadin.ui.Label;
import com.vaadin.ui.Notification;
import com.vaadin.ui.OptionGroup;
import com.vaadin.ui.VerticalLayout;

public class AddEmpPrivilegeStep implements WizardStep {

    private CheckBox allowBack;
    private VerticalLayout layout;
    private final Wizard owner;
    FieldGroup privilegeBinder;

    public AddEmpPrivilegeStep(FieldGroup privilegeBinder, Wizard owner) {
        this.owner = owner;
        this.privilegeBinder = privilegeBinder;
    }

    @Override
    public String getCaption() {
        return "Choose Privilege";
    }

    @Override
    public Component getContent() {
        if (layout == null) {
            allowBack = new CheckBox("Allow back?", false);

            layout = new VerticalLayout();
            layout.setMargin(true);
            layout.addComponent(new Label("<h2>Set Privilege to the Employee</h2>", ContentMode.HTML));
            IndexedContainer container = new IndexedContainer();
            container.addContainerProperty("name", String.class, null);
            OptionGroup group = new OptionGroup("My Select", container);
            layout.addComponent(group);

        }
        return layout;
    }

    @Override
    public boolean onAdvance() {
        return true;
    }

    @Override
    public boolean onBack() {
        boolean allowed = allowBack.getValue();
        if (!allowed) {
            Notification.show("Not allowed, sorry");
        }
        return allowed;
    }
}