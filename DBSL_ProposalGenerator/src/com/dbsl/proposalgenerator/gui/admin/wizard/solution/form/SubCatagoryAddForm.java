package com.dbsl.proposalgenerator.gui.admin.wizard.solution.form;

import java.io.IOException;
import java.util.Date;

import com.dbsl.proposalgenerator.beans.StaticText;
import com.vaadin.ui.CustomComponent;
import com.vaadin.ui.DateField;
import com.vaadin.ui.FormLayout;
import com.vaadin.ui.TextField;

@SuppressWarnings("serial")
public class SubCatagoryAddForm extends CustomComponent {
	private TextField title;
	private TextField name;
	private DateField createdOn;
	private TextField oneOffCost;
	private StaticTextForm staticForm;

	public SubCatagoryAddForm() {
		super();
		title = new TextField("Title");
		name = new TextField("Name");
		createdOn = new DateField("Created On", new Date());
		oneOffCost = new TextField("One Off Cost");
		staticForm = new StaticTextForm();

		title.setNullRepresentation("");
		name.setNullRepresentation("");
		createdOn.setEnabled(false);
		oneOffCost.setNullRepresentation("");

		FormLayout form = new FormLayout(title, name, oneOffCost, createdOn,
				staticForm);
		setCompositionRoot(form);

	}

	public StaticText getStaticText() throws IOException {
		/*
		 * BeanItem<StaticText> text = new BeanItem<StaticText>(new
		 * StaticText()); FieldGroup binder = new FieldGroup(text);
		 * binder.bindMemberFields(staticForm); return text.getBean();
		 */
		return staticForm.getStaticText();
	}

}
