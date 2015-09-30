package com.dbsl.proposalgenerator.gui.admin.wizard.employee;

import java.util.Date;

import org.vaadin.teemu.wizards.Wizard;
import org.vaadin.teemu.wizards.WizardStep;

import com.dbsl.proposalgenerator.beans.Employee;
import com.vaadin.data.util.BeanItem;
import com.vaadin.shared.ui.label.ContentMode;
import com.vaadin.ui.Button;
import com.vaadin.ui.Button.ClickEvent;
import com.vaadin.ui.CheckBox;
import com.vaadin.ui.Component;
import com.vaadin.ui.Label;
import com.vaadin.ui.Notification;
import com.vaadin.ui.VerticalLayout;

public class AddEmpPrivilegeStep implements WizardStep {

    private CheckBox allowBack;
    private VerticalLayout layout;
    private final Wizard owner;
    Employee employee;

    public AddEmpPrivilegeStep(BeanItem<Employee> employeeItem, Wizard owner) {
        this.owner = owner;
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
            layout.addComponent(new Label(
                    "<h2>Need more steps?</h2><p>You can also dynamically add new steps. Try it out with the button below.</p>",
                    ContentMode.HTML));
            layout.addComponent(new Button("Add new steps", new Button.ClickListener() {

                private static final long serialVersionUID = 1L;

                @Override
                public void buttonClick(ClickEvent event) {
                    owner.addStep(new WizardStep() {

                        private final Date createdAt = new Date();

                        @Override
                        public boolean onBack() {
                            return true;
                        }

                        @Override
                        public boolean onAdvance() {
                            return true;
                        }

                        @Override
                        public Component getContent() {
                            VerticalLayout layout = new VerticalLayout();
                            layout.setMargin(true);
                            layout.addComponent(new Label("This step was created on " + createdAt));
                            return layout;
                        }

                        @Override
                        public String getCaption() {
                            return "Generated step";
                        }
                    });
                }
            }));

            layout.addComponent(new Label(
                    "<h2>Want to go back?</h2><p>This step is also an example of conditionally allowing you to go back.<br />"
                            + "Try to click the back button and then again after checking the checkbox below.</p>",
                    ContentMode.HTML));
            layout.addComponent(allowBack);
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