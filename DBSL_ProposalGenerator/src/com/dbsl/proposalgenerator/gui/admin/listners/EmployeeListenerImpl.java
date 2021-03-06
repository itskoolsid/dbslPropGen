package com.dbsl.proposalgenerator.gui.admin.listners;

import com.dbsl.proposalgenerator.gui.admin.EmployeeWizard;
import com.vaadin.shared.ui.window.WindowMode;
import com.vaadin.ui.MenuBar;
import com.vaadin.ui.MenuBar.MenuItem;
import com.vaadin.ui.UI;
import com.vaadin.ui.Window;
import com.vaadin.ui.Window.CloseEvent;
import com.vaadin.ui.Window.CloseListener;

@SuppressWarnings("serial")
public class EmployeeListenerImpl implements EmployeeListener, MenuBar.Command {

    UI parent;
    Window addWindow, editWindow, deleteWindow, searchWindow;

    public EmployeeListenerImpl(UI parentUI) {
        parent = parentUI;
    }

    @Override
    public void addEmployee() {
        if (addWindow == null) {
            addWindow = new Window("Add Employee Details");
            addWindow.setResponsive(true);
            addWindow.setWindowMode(WindowMode.MAXIMIZED);
            addWindow.addCloseListener(new CloseListener() {

                @Override
                public void windowClose(CloseEvent e) {
                    addWindow = null;
                }
            });
            addWindow.setContent(new EmployeeWizard());
            addWindow.center();
            parent.addWindow(addWindow);
        }

    }

    @Override
    public void editEmployee() {
        if (editWindow == null) {
            editWindow = new Window("Edit Employee Details");
            editWindow.addCloseListener(new CloseListener() {

                @Override
                public void windowClose(CloseEvent e) {
                    editWindow = null;
                }
            });
            editWindow.center();
            parent.addWindow(editWindow);
        }
    }

    @Override
    public void deleteEmployee() {
        if (deleteWindow == null) {
            deleteWindow = new Window("Delete Employee Details");
            deleteWindow.addCloseListener(new CloseListener() {

                @Override
                public void windowClose(CloseEvent e) {
                    deleteWindow = null;
                }
            });
            deleteWindow.center();
            parent.addWindow(deleteWindow);
        }
    }

    @Override
    public void searchEmployee() {
        if (searchWindow == null) {
            searchWindow = new Window("Search an Employee");
            searchWindow.addCloseListener(new CloseListener() {

                @Override
                public void windowClose(CloseEvent e) {
                    searchWindow = null;
                }
            });
            searchWindow.center();
            parent.addWindow(searchWindow);
        }
    }

    @Override
    public void menuSelected(MenuItem selectedItem) {
        switch (selectedItem.getText()) {
        case "Add New":
            addEmployee();
            break;
        case "Edit":
            editEmployee();
            break;
        case "Delete":
            deleteEmployee();
            break;
        case "Search":
            searchEmployee();
            break;

        default:
            break;
        }
    }

}
