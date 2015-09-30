package com.dbsl.proposalgenerator.gui.admin;

import com.dbsl.proposalgenerator.beans.Employee;
import com.vaadin.data.Item;
import com.vaadin.data.fieldgroup.FieldGroup;
import com.vaadin.data.fieldgroup.PropertyId;
import com.vaadin.data.util.BeanItem;
import com.vaadin.ui.CustomComponent;
import com.vaadin.ui.FormLayout;
import com.vaadin.ui.TextField;

public class EmployeeForm extends CustomComponent {
    // Member that will bind to the "name" property
    TextField name = new TextField("Name");

    // Member that will bind to the "age" property
    @PropertyId("age")
    TextField ageField = new TextField("Age");

    public EmployeeForm(Item item) {
        // the 'POJO' we're editing
        Employee person;

        person = new Employee(); // a person POJO
        BeanItem<Employee> personItem = new BeanItem<Employee>(person); // item from

        FormLayout layout = new FormLayout();
        /*
         * layout.addComponent(name); layout.addComponent(ageField);
         */

        // Now use a binder to bind the members
        FieldGroup binder = new FieldGroup(personItem);
        binder.bindMemberFields(this);
        setCompositionRoot(layout);
    }

}
