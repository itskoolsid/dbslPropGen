package com.dbsl.proposalgenerator.gui.admin.wizard.solution.form;

import java.io.IOException;
import java.util.Date;

import com.dbsl.proposalgenerator.beans.StaticText;
import com.dbsl.proposalgenerator.commons.util.FileUploader;
import com.vaadin.ui.CustomComponent;
import com.vaadin.ui.DateField;
import com.vaadin.ui.FormLayout;
import com.vaadin.ui.RichTextArea;
import com.vaadin.ui.TextField;

@SuppressWarnings("serial")
public class StaticTextForm extends CustomComponent {
	private TextField heading;
	private RichTextArea content;
	private DateField createdOn;

	public StaticTextForm() {
		heading = new TextField("Heading");
		content = new RichTextArea("Content");
		createdOn = new DateField("Created On", new Date());

		createdOn.setEnabled(false);
		FormLayout form = new FormLayout(heading, content, createdOn);
		setCompositionRoot(form);
	}

	public StaticText getStaticText() throws IOException {
		StaticText staticText = new StaticText();
		staticText.setHeading(heading.getValue());
		staticText.setFilePath(FileUploader.saveFile(heading.getValue()
				+ System.currentTimeMillis(), content.getValue()));
		staticText.setCreatedOn(new Date());
		staticText.setIsActive(true);
		staticText.setUpdatedOn(new Date());
		return staticText;
	}
}
