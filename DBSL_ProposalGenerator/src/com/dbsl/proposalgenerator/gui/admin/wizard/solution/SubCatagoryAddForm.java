package com.dbsl.proposalgenerator.gui.admin.wizard.solution;

import java.util.Date;

import com.vaadin.ui.CustomComponent;
import com.vaadin.ui.DateField;
import com.vaadin.ui.FormLayout;
import com.vaadin.ui.RichTextArea;
import com.vaadin.ui.TextField;

@SuppressWarnings("serial")
public class SubCatagoryAddForm extends CustomComponent {
	private TextField title;
	private TextField name;
	private DateField createdOn;
	private TextField oneOffCost;
	private RichTextArea content;

	public SubCatagoryAddForm() {
		super();
		title = new TextField("Title");
		name = new TextField("Name");
		createdOn = new DateField("Created On", new Date());
		oneOffCost = new TextField("One Off Cost");
		content = new RichTextArea("Contents");

		title.setNullRepresentation("");
		name.setNullRepresentation("");
		createdOn.setEnabled(false);
		oneOffCost.setNullRepresentation("");

		FormLayout form = new FormLayout(title, name, oneOffCost, createdOn,
				content);
		setCompositionRoot(form);

	}

	public String getContents() {
		return content.getValue();
	}

}
