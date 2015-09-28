package com.dbsl.proposalgenerator.admin.gui;

import org.vaadin.teemu.VaadinIcons;

import com.vaadin.server.FontAwesome;
import com.vaadin.ui.MenuBar;
import com.vaadin.ui.Notification;

@SuppressWarnings("serial")
public class AdminMenuBar extends MenuBar {
    MenuItem manageEmployees, manageProposals, manageClients;

    public AdminMenuBar() {
        super();
        manageEmployees = addItem("Manage Employees", FontAwesome.USERS, null);
        manageProposals = addItem("Manage Proposals", FontAwesome.FILE_TEXT, command);
        manageClients = addItem("Manage Clients", FontAwesome.BRIEFCASE, command);

        manageEmployees.addItem("Edit", FontAwesome.EDIT, command);
        manageEmployees.addItem("Edit", VaadinIcons.CLOSE, command);
        manageEmployees.addItem("Edit", FontAwesome.EDIT, command);
    }

    MenuBar.Command command = new MenuBar.Command() {
        @Override
        public void menuSelected(MenuItem selectedItem) {
            Notification.show("Hola");
        }
    };

}
