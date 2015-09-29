package com.dbsl.proposalgenerator.gui.admin;

import org.vaadin.teemu.VaadinIcons;

import com.vaadin.server.FontAwesome;
import com.vaadin.ui.MenuBar;
import com.vaadin.ui.Notification;

@SuppressWarnings("serial")
public class AdminMenuBar extends MenuBar {
    MenuItem manageEmployees, manageProposals, manageClients;

    public AdminMenuBar() {
        super();
        manageEmployees = addItem("Employees", FontAwesome.USERS, null);
        manageProposals = addItem("Proposal Templates", FontAwesome.FILE_TEXT, null);
        manageClients = addItem("Clients", FontAwesome.BRIEFCASE, null);
        

        manageEmployees.addItem("Add New", VaadinIcons.PLUS, command);
        manageEmployees.addItem("Edit", VaadinIcons.EDIT, command);
        manageEmployees.addItem("Delete", VaadinIcons.CLOSE, command);
        manageEmployees.addItem("Search", VaadinIcons.SEARCH, command);

        manageProposals.addItem("Create New", VaadinIcons.PLUS_CIRCLE, command);
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
            Notification.show("Hola");
        }
    };

}
