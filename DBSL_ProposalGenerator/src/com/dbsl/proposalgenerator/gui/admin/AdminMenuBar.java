package com.dbsl.proposalgenerator.gui.admin;

import org.vaadin.teemu.VaadinIcons;

import com.dbsl.proposalgenerator.gui.admin.listners.EmployeeListenerImpl;
import com.dbsl.proposalgenerator.gui.admin.listners.SolutionListener;
import com.dbsl.proposalgenerator.gui.admin.listners.SolutionListenerImpl;
import com.vaadin.server.FontAwesome;
import com.vaadin.ui.Button;
import com.vaadin.ui.Label;
import com.vaadin.ui.MenuBar;
import com.vaadin.ui.UI;
import com.vaadin.ui.VerticalLayout;
import com.vaadin.ui.Window;

@SuppressWarnings("serial")
public class AdminMenuBar extends MenuBar {
	MenuItem manageEmployees, manageProposals, manageClients;
	UI parentUI;
	Window employeeWidnow, clientWindow, proposalWindow;
	EmployeeListenerImpl empListener;
	SolutionListener solutionListener;

	public AdminMenuBar(UI parent) {
		super();
		parentUI = parent;
		empListener = new EmployeeListenerImpl(parent);
		solutionListener = new SolutionListenerImpl(parent);
		manageEmployees = addItem("Employees", FontAwesome.USERS, null);
		manageProposals = addItem("Proposal Templates", FontAwesome.FILE_TEXT,
				null);
		manageClients = addItem("Clients", FontAwesome.BRIEFCASE, null);

		manageEmployees.addItem("Add New", VaadinIcons.PLUS, empListener);
		manageEmployees.addItem("Edit", VaadinIcons.EDIT, empListener);
		manageEmployees.addItem("Delete", VaadinIcons.CLOSE, empListener);
		manageEmployees.addItem("Search", VaadinIcons.SEARCH, empListener);

		manageProposals.addItem("Create New", VaadinIcons.PLUS_CIRCLE,
				solutionListener);
		manageProposals.addItem("Edit", VaadinIcons.EDIT, command);
		manageProposals.addItem("Delete", VaadinIcons.CLOSE_CIRCLE, command);
		manageProposals.addItem("Search", VaadinIcons.SEARCH, command);

		manageClients.addItem("Add New", VaadinIcons.PLUS, command);
		manageClients.addItem("Edit", VaadinIcons.EDIT, command);
		manageClients.addItem("Delete", VaadinIcons.CLOSE, command);
		manageClients.addItem("Search", VaadinIcons.SEARCH, command);

	}

	MenuBar.Command command = new MenuBar.Command() {
		@Override
		public void menuSelected(MenuItem selectedItem) {
			Window subWindow = new Window("Sub-window");
			VerticalLayout subContent = new VerticalLayout();
			subContent.setMargin(true);
			subWindow.setContent(subContent);

			// Put some components in it
			subContent.addComponent(new Label("Meatball sub"));
			subContent.addComponent(new Button("Awlright"));

			// Center it in the browser window
			subWindow.center();

			// Open it in the UI
			parentUI.addWindow(subWindow);
		}
	};

}
