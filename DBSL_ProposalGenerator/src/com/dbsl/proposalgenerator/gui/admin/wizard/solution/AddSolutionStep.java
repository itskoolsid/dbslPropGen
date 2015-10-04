package com.dbsl.proposalgenerator.gui.admin.wizard.solution;

import org.vaadin.teemu.wizards.WizardStep;

import com.vaadin.data.fieldgroup.FieldGroup;
import com.vaadin.data.fieldgroup.FieldGroup.CommitException;
import com.vaadin.ui.Component;
import com.vaadin.ui.VerticalLayout;

public class AddSolutionStep implements WizardStep {

	private SolutionAddForm form;
	FieldGroup solutionBinder;

	public AddSolutionStep(FieldGroup solFieldGroup) {
		super();
		this.solutionBinder = solFieldGroup;
	}

	@Override
	public String getCaption() {
		return "Solution Details";
	}

	@Override
	public Component getContent() {
		VerticalLayout content = new VerticalLayout();
		content.setSizeFull();
		content.setMargin(true);
		content.addComponent(form);
		return content;
	}

	@Override
	public boolean onAdvance() {
		try {
			solutionBinder.commit();
		} catch (CommitException e) {
			e.printStackTrace();
		}
		return true;
	}

	@Override
	public boolean onBack() {
		return true;
	}

}
