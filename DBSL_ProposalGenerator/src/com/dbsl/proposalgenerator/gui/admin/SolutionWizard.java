package com.dbsl.proposalgenerator.gui.admin;

import org.vaadin.teemu.wizards.Wizard;
import org.vaadin.teemu.wizards.event.WizardCancelledEvent;
import org.vaadin.teemu.wizards.event.WizardCompletedEvent;
import org.vaadin.teemu.wizards.event.WizardProgressListener;
import org.vaadin.teemu.wizards.event.WizardStepActivationEvent;
import org.vaadin.teemu.wizards.event.WizardStepSetChangedEvent;

import com.dbsl.proposalgenerator.beans.Solution;
import com.dbsl.proposalgenerator.gui.admin.wizard.solution.AddHardwareStep;
import com.dbsl.proposalgenerator.gui.admin.wizard.solution.AddMonthlyCostStep;
import com.dbsl.proposalgenerator.gui.admin.wizard.solution.AddSolutionStep;
import com.dbsl.proposalgenerator.gui.admin.wizard.solution.AddSubCatagoryStep;
import com.vaadin.server.Page;
import com.vaadin.ui.Alignment;
import com.vaadin.ui.VerticalLayout;

public class SolutionWizard extends VerticalLayout implements
		WizardProgressListener {

	Wizard wizard;

	public SolutionWizard() {
		// TODO Auto-generated constructor stub
		wizard = new Wizard();
		wizard.setUriFragmentEnabled(false);
		wizard.addListener(this);
		Solution solution = new Solution();
		wizard.addStep(new AddSolutionStep(solFieldGroup), "empDetails");
		wizard.addStep(new AddSubCatagoryStep(conBinder), "empContact");
		wizard.addStep(new AddMonthlyCostStep(addressBinder), "empAddress");
		wizard.addStep(new AddHardwareStep(privilegeBinder, wizard),
				"empPrivilege");
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
