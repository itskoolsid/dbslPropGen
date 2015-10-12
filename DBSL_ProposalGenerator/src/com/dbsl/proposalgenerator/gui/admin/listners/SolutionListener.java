package com.dbsl.proposalgenerator.gui.admin.listners;

import com.vaadin.ui.MenuBar;

public interface SolutionListener extends MenuBar.Command {
	public void addSolution();

	public void editSolution();

	public void deleteSolution();

	public void searchSolution();
}
