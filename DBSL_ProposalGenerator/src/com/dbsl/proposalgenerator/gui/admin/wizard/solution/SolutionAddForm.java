package com.dbsl.proposalgenerator.gui.admin.wizard.solution;

import java.util.Date;

import com.dbsl.proposalgenerator.commons.util.ImageUploadPanel;
import com.vaadin.ui.CustomComponent;
import com.vaadin.ui.DateField;
import com.vaadin.ui.FormLayout;
import com.vaadin.ui.TextField;

@SuppressWarnings("serial")
public class SolutionAddForm extends CustomComponent {

	private TextField name;
	private TextField motto;
	private TextField logoPath;
	private DateField createdOn;
	private ImageUploadPanel upload;

	public SolutionAddForm() {
		name = new TextField("Solution Name");
		motto = new TextField("Solution Motto");
		createdOn = new DateField("Created On", new Date());
		upload = new ImageUploadPanel();

		name.setNullRepresentation("");
		motto.setNullRepresentation("");
		createdOn.setEnabled(false);

		FormLayout form = new FormLayout(name, motto, createdOn, upload);
		setCompositionRoot(form);
	}

}
