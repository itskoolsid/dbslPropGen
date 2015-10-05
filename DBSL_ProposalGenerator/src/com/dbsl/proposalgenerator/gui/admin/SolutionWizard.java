package com.dbsl.proposalgenerator.gui.admin;

import org.vaadin.teemu.wizards.Wizard;
import org.vaadin.teemu.wizards.event.WizardCancelledEvent;
import org.vaadin.teemu.wizards.event.WizardCompletedEvent;
import org.vaadin.teemu.wizards.event.WizardProgressListener;
import org.vaadin.teemu.wizards.event.WizardStepActivationEvent;
import org.vaadin.teemu.wizards.event.WizardStepSetChangedEvent;

import com.dbsl.proposalgenerator.beans.Solution;
import com.vaadin.data.fieldgroup.FieldGroup;
import com.vaadin.data.util.BeanItem;
import com.vaadin.server.Page;
import com.vaadin.ui.Alignment;
import com.vaadin.ui.VerticalLayout;

public class SolutionWizard extends VerticalLayout implements WizardProgressListener {

    Wizard wizard;

    public SolutionWizard() {
        // TODO Auto-generated constructor stub
        wizard = new Wizard();
        wizard.setUriFragmentEnabled(false);
        wizard.addListener(this);
        Solution solution = new Solution();
        FieldGroup solBinder = new FieldGroup(new BeanItem<Solution>(solution));
        /*
         * wizard.addStep(new AddSolutionStep(solBinder), "empDetails"); wizard.addStep(new
         * AddExecutionSummeryStep(addressBinder)); wizard.addStep(new AddSubCatagoryStep(), "empContact"); wizard.addStep(new
         * AddMonthlyCostStep(), "empAddress"); wizard.addStep(new AddHardwareStep(), "empPrivilege");
         */
        wizard.setSizeFull();
        addComponent(wizard);
        setComponentAlignment(wizard, Alignment.TOP_CENTER);
    }

    @Override
    public void activeStepChanged(WizardStepActivationEvent event) {
        Page.getCurrent().setTitle(event.getActivatedStep().getCaption());
    }

    @Override
    public void stepSetChanged(WizardStepSetChangedEvent event) {
        // TODO Auto-generated method stub

    }

    @Override
    public void wizardCompleted(WizardCompletedEvent event) {
        // TODO Auto-generated method stub

    }

    @Override
    public void wizardCancelled(WizardCancelledEvent event) {
        // TODO Auto-generated method stub

    }

}
