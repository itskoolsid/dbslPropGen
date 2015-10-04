package com.dbsl.proposalgenerator.gui.admin.wizard.solution;

import com.vaadin.ui.CustomComponent;
import com.vaadin.ui.FormLayout;
import com.vaadin.ui.TextField;

@SuppressWarnings("serial")
public class MonthlyCostAddForm extends CustomComponent {
	private TextField name;
	private TextField unitPrice;

	public MonthlyCostAddForm() {
		super();
		name = new TextField("Name");
		unitPrice = new TextField("Unit Price");

		setCompositionRoot(new FormLayout(name, unitPrice));
	}

}
