package com.dbsl.proposalgenerator.gui.admin.listners;

import com.dbsl.proposalgenerator.gui.admin.EmployeeWizard;
import com.vaadin.shared.ui.window.WindowMode;
import com.vaadin.ui.UI;
import com.vaadin.ui.Window;
import com.vaadin.ui.Window.CloseEvent;
import com.vaadin.ui.Window.CloseListener;

public class SolutionListenerImpl implements SolutionListener {

	UI parent;
	Window addWindow, editWindow, deleteWindow, searchWindow;

	public SolutionListenerImpl(UI parent) {
		super();
		this.parent = parent;
	}

	@Override
	public void addSolution() {
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
	public void editSolution() {

	}

	@Override
	public void deleteSolution() {

	}

	@Override
	public void searchSolution() {

	}

}
