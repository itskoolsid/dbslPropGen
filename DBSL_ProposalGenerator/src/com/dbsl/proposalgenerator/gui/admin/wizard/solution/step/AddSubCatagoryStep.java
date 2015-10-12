package com.dbsl.proposalgenerator.gui.admin.wizard.solution.step;

import java.io.IOException;

import org.vaadin.teemu.wizards.WizardStep;

import com.dbsl.proposalgenerator.beans.StaticText;
import com.dbsl.proposalgenerator.gui.admin.wizard.solution.form.SubCatagoryAddForm;
import com.vaadin.data.fieldgroup.FieldGroup;
import com.vaadin.data.fieldgroup.FieldGroup.CommitException;
import com.vaadin.server.ThemeResource;
import com.vaadin.shared.ui.label.ContentMode;
import com.vaadin.ui.Component;
import com.vaadin.ui.Embedded;
import com.vaadin.ui.Label;
import com.vaadin.ui.VerticalLayout;

public class AddSubCatagoryStep implements WizardStep {
	FieldGroup categoryBinder;
	SubCatagoryAddForm form;

	public AddSubCatagoryStep(FieldGroup categoryBinder) {
		this.categoryBinder = categoryBinder;
		form = new SubCatagoryAddForm();
		categoryBinder.bindMemberFields(form);
	}

	@Override
	public String getCaption() {
		return "Add Category";
	}

	@Override
	public Component getContent() {
		VerticalLayout content = new VerticalLayout();
		content.setSizeFull();
		content.setMargin(true);
		content.addComponent(form);
		return content;
	}

	private Label getText() {
		return new Label("<h2>Add Employee Address</h2>", ContentMode.HTML);
	}

	private Embedded getArrow() {
		Embedded arrow = new Embedded("", new ThemeResource("img/arrow-up.png"));
		arrow.setStyleName("listen-arrow");
		return arrow;
	}

	@Override
	public boolean onAdvance() {
		try {
			categoryBinder.commit();

		} catch (CommitException e) {
			e.printStackTrace();
		}
		return true;
	}

	@Override
	public boolean onBack() {
		return true;
	}

	public StaticText getStaticText() throws IOException {
		return form.getStaticText();
	}
}
