package com.dbsl.proposalgenerator.gui.admin.wizard.solution;

import com.dbsl.proposalgenerator.beans.Specification;
import com.vaadin.ui.HorizontalLayout;
import com.vaadin.ui.TextField;

@SuppressWarnings("serial")
public class SpecificationAddForm extends HorizontalLayout {
	private TextField key;
	private TextField value;

	public SpecificationAddForm() {
		key = new TextField();
		value = new TextField();

		addComponent(key);
		addComponent(value);

		key.setNullRepresentation("");
		value.setNullRepresentation("");
	}

	public Specification getSpecification() {
		Specification specification = new Specification();
		specification.setIsActive(true);
		specification.setKey(key.getValue());
		specification.setValue(value.getValue());
		return specification;
	}

}
