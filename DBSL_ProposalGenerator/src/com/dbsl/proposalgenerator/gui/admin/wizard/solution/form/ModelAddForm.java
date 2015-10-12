package com.dbsl.proposalgenerator.gui.admin.wizard.solution.form;

import java.util.Collection;
import java.util.HashSet;
import java.util.Set;

import org.vaadin.teemu.VaadinIcons;

import com.dbsl.proposalgenerator.beans.Specification;
import com.dbsl.proposalgenerator.commons.util.ImageUploadPanel;
import com.vaadin.ui.Button;
import com.vaadin.ui.Button.ClickEvent;
import com.vaadin.ui.Button.ClickListener;
import com.vaadin.ui.CustomComponent;
import com.vaadin.ui.FormLayout;
import com.vaadin.ui.HorizontalLayout;
import com.vaadin.ui.Table;
import com.vaadin.ui.TextField;
import com.vaadin.ui.VerticalLayout;

@SuppressWarnings("serial")
public class ModelAddForm extends CustomComponent {
	private TextField name;
	private TextField unitPrice;
	private ImageUploadPanel imageUploadPanel;
	private Button addSpecification;
	private Table table;
	private SpecificationAddForm specificationAddForm;
	private HorizontalLayout horizontalLayout;
	private VerticalLayout verticalLayout;
	private Button removeButton;
	private Set<Specification> specifications;

	public ModelAddForm() {
		name = new TextField("Name");
		unitPrice = new TextField("Unit Price");
		imageUploadPanel = new ImageUploadPanel();
		addSpecification = new Button("Add Specification",
				VaadinIcons.PLUS_CIRCLE);
		table = new Table("Specifications");
		specificationAddForm = new SpecificationAddForm();
		horizontalLayout = new HorizontalLayout();
		specifications = new HashSet<>();

		FormLayout form = new FormLayout();
		form.addComponent(name);
		form.addComponent(unitPrice);
		form.addComponent(imageUploadPanel);
		verticalLayout = new VerticalLayout();
		verticalLayout.addComponent(horizontalLayout);
		horizontalLayout.addComponent(specificationAddForm);
		horizontalLayout.addComponent(addSpecification);
		verticalLayout.addComponent(table);
		form.addComponent(verticalLayout);
		setCompositionRoot(form);

		addSpecification.addClickListener(new ClickListener() {

			@Override
			public void buttonClick(ClickEvent event) {
				removeButton = new Button("Delete", VaadinIcons.MINUS_CIRCLE);
				Specification specification = specificationAddForm
						.getSpecification();
				table.addItem(new Object[] { specification.getKey(),
						specification.getValue(), removeButton }, removeButton);
				removeButton.addClickListener(new ClickListener() {

					@Override
					public void buttonClick(ClickEvent event) {
						table.removeItem(event.getButton());
					}
				});
			}
		});
	}

	@SuppressWarnings("unchecked")
	public Set<Specification> getSpecifications() {
		Collection<Button> itemIds = (Collection<Button>) table.getItemIds();
		Collection<Button> ids = itemIds;
		for (Button id : ids)
			specifications.add((Specification) table.getItem(id));
		return specifications;
	}

}
