package com.dbsl.proposalgenerator.user.gui;

import javax.servlet.annotation.WebServlet;

import com.dbsl.proposalgenerator.admin.gui.AdminMenuBar;
import com.vaadin.annotations.Theme;
import com.vaadin.annotations.VaadinServletConfiguration;
import com.vaadin.server.VaadinRequest;
import com.vaadin.server.VaadinServlet;
import com.vaadin.ui.Component;
import com.vaadin.ui.HorizontalLayout;
import com.vaadin.ui.UI;
import com.vaadin.ui.VerticalLayout;

@SuppressWarnings("serial")
@Theme("dbsl_proposalgen_theme")
public class MainUI extends UI {
    public LeftMenu leftMenu;
    public VerticalLayout leftMenuContainer;

    @WebServlet(value = "/*", asyncSupported = true)
    @VaadinServletConfiguration(productionMode = false, ui = MainUI.class)
    public static class Servlet extends VaadinServlet {
    }

    @Override
    protected void init(VaadinRequest request) {
        final HorizontalLayout layout = new HorizontalLayout();
        layout.setSpacing(true);
        /*
         * leftMenu = new LeftMenu(); leftMenuContainer = new VerticalLayout(leftMenu); layout.addComponent(leftMenuContainer);
         * layout.setExpandRatio(leftMenuContainer, 1); leftMenuContainer.setComponentAlignment(leftMenu,
         * Alignment.MIDDLE_CENTER); leftMenuContainer.setStyleName("leftMenu"); leftMenuContainer.setSizeFull();
         */

        Component comp = addMenu();
        layout.addComponent(comp);

        layout.setExpandRatio(comp, 4);

        setContent(layout);
        layout.setSizeFull();
    }

    private Component addMenu() {
        return new AdminMenuBar();
    }

}