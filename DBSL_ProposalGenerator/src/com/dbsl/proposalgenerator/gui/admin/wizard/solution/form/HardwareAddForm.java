package com.dbsl.proposalgenerator.gui.admin.wizard.solution.form;

import org.vaadin.teemu.VaadinIcons;

import com.vaadin.ui.Button;
import com.vaadin.ui.Button.ClickEvent;
import com.vaadin.ui.Button.ClickListener;
import com.vaadin.ui.CustomComponent;
import com.vaadin.ui.CustomLayout;
import com.vaadin.ui.TextField;
import com.vaadin.ui.VerticalLayout;
import com.vaadin.ui.Window;

@SuppressWarnings("serial")
public class HardwareAddForm extends CustomComponent {
	private TextField name;
	private ModelAddForm modelAddForm;
	private SpecificationAddForm specificationAddForm;
	private VerticalLayout layout;
	private Button addButton;

	@SuppressWarnings("serial")
	public HardwareAddForm() {
		// TODO Auto-generated constructor stub
		name = new TextField("Name");
		layout = new VerticalLayout();
		addButton = new Button("Add Hardware", VaadinIcons.PLUS_CIRCLE);
		addButton.addClickListener(new ClickListener() {

			@Override
			public void buttonClick(ClickEvent event) {
				Window window = new Window("Add Hardware Details");
				CustomLayout customLayout = new CustomLayout();
				modelAddForm = new ModelAddForm();
				customLayout.addComponent(name);
				customLayout.addComponent(modelAddForm);

				customLayout.addComponent(new Button("Submit",
						new ClickListener() {

							@Override
							public void buttonClick(ClickEvent event) {

							}
						}));
				window.setContent(customLayout);
				window.center();
			}
		});
		specificationAddForm = new SpecificationAddForm();

	}

}
