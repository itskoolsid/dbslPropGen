package com.dbsl.proposalgenerator;

import javax.servlet.annotation.WebServlet;

import com.vaadin.annotations.Theme;
import com.vaadin.annotations.VaadinServletConfiguration;
import com.vaadin.server.FontAwesome;
import com.vaadin.server.ThemeResource;
import com.vaadin.server.VaadinRequest;
import com.vaadin.server.VaadinServlet;
import com.vaadin.ui.Alignment;
import com.vaadin.ui.Button.ClickEvent;
import com.vaadin.ui.Button.ClickListener;
import com.vaadin.ui.Component;
import com.vaadin.ui.HorizontalLayout;
import com.vaadin.ui.Label;
import com.vaadin.ui.MenuBar;
import com.vaadin.ui.MenuBar.MenuItem;
import com.vaadin.ui.RichTextArea;
import com.vaadin.ui.TabSheet;
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
        leftMenu = new LeftMenu();
        leftMenuContainer = new VerticalLayout(leftMenu);
        layout.addComponent(leftMenuContainer);
        layout.setExpandRatio(leftMenuContainer, 1);
        leftMenuContainer.setComponentAlignment(leftMenu, Alignment.MIDDLE_CENTER);
        leftMenuContainer.setStyleName("leftMenu");
        leftMenuContainer.setSizeFull();

        TabSheet tabsheet = new TabSheet();
        Component comp = addMenu();
        layout.addComponent(comp);

        Component textarea = initializeButton();
        layout.addComponent(textarea);
        // Create the first tab
        VerticalLayout tab1 = new VerticalLayout();

        tabsheet.addTab(tab1, "Mercury", FontAwesome.BOOK);

        // This tab gets its caption from the component caption
        VerticalLayout tab2 = new VerticalLayout();
        tab2.setCaption("Venus");
        tabsheet.addTab(tab2).setIcon(FontAwesome.FILE_PDF_O);
        comp.setWidth(100, Unit.PERCENTAGE);

        layout.setExpandRatio(comp, 4);

        setContent(layout);
        layout.setSizeFull();
    }

    private Component initializeButton() {
        final RichTextArea rtarea = new RichTextArea();
        leftMenu.home.addClickListener(new ClickListener() {
            @Override
            public void buttonClick(ClickEvent event) {
                // TODO Auto-generated method stub
                // Create a rich text area
                rtarea.setCaption("My Rich Text Area");

                // Set initial content as HTML
                rtarea.setValue("<h1>Hello</h1>\n" + "<p>This rich text area contains some text.</p>");

            }
        });
        return rtarea;
    }

    private Component addMenu() {
        final MenuBar barmenu = new MenuBar();
        // TODO Auto-generated method stub
        MenuItem drinks = barmenu.addItem("Messages", FontAwesome.ENVELOPE, null);

        final Label selection = new Label("-");

        // Define a common menu command for all the menu items.
        final MenuBar.Command mycommand = new MenuBar.Command() {
            @Override
            public void menuSelected(MenuItem selectedItem) {
                selection.setValue("Ordered a " + selectedItem.getText() + " from menu.");
            }
        };
        // Submenu item with a sub-submenu
        MenuItem hots = drinks.addItem("Drafts", FontAwesome.PENCIL, null);
        hots.addItem("Tea", FontAwesome.MAGIC, mycommand);
        hots.addItem("Coffee", new ThemeResource("icons/coffee-16px.png"), mycommand);

        // Another submenu item with a sub-submenu
        MenuItem colds = drinks.addItem("Cold", null, null);
        colds.addItem("Milk", null, mycommand);
        colds.addItem("Weissbier", null, mycommand);

        // Another top-level item
        MenuItem snacks = barmenu.addItem("Drafts", FontAwesome.PENCIL, null);
        snacks.addItem("Weisswurst", null, mycommand);
        snacks.addItem("Bratwurst", null, mycommand);
        snacks.addItem("Currywurst", null, mycommand);

        // Yet another top-level item
        MenuItem servs = barmenu.addItem("Settings", FontAwesome.GEARS, null);
        servs.addItem("Car Service", null, mycommand);
        return barmenu;
    }

}