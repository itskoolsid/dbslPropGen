package com.dbsl.proposalgenerator.gui.admin.wizard.solution;

import com.vaadin.ui.FormLayout;
import com.vaadin.ui.RichTextArea;
import com.vaadin.ui.TextField;

@SuppressWarnings("serial")
public class ExecutiveSummeryAddForm extends FormLayout {
	private TextField heading;
	private RichTextArea summeryContent;

	public ExecutiveSummeryAddForm() {
		super();
		heading = new TextField("Heading");
		summeryContent = new RichTextArea("Content");

		heading.setNullRepresentation("");
		summeryContent.setNullRepresentation("");

		addComponent(heading);
		addComponent(summeryContent);

	}

	public String getContent() {
		return summeryContent.getValue();
	}

}
