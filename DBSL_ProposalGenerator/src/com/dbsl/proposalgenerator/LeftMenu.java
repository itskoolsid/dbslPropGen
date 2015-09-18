package com.dbsl.proposalgenerator;

import org.vaadin.teemu.VaadinIcons;

import com.vaadin.ui.Button;
import com.vaadin.ui.VerticalLayout;

@SuppressWarnings("serial")
public class LeftMenu extends VerticalLayout {

    public Button home;
    public Button createProposal;
    public Button accessProposal;
    public Button customerInfo;
    public Button productCatalogue;
    public Button customerSupport;

    public LeftMenu() {
        setId("leftMenu");
        setStyleName("leftMenu");
        home = new Button("Home", VaadinIcons.HOME);
        createProposal = new Button("Create Proposal");
        accessProposal = new Button("Access Proposal");
        customerInfo = new Button("Customer Info");
        productCatalogue = new Button("Product Catalogue");
        customerSupport = new Button("Customer Support");
        home.setWidth(100, Unit.PERCENTAGE);
        createProposal.setWidth(100, Unit.PERCENTAGE);
        accessProposal.setWidth(100, Unit.PERCENTAGE);
        customerInfo.setWidth(100, Unit.PERCENTAGE);
        customerSupport.setWidth(100, Unit.PERCENTAGE);
        productCatalogue.setWidth(100, Unit.PERCENTAGE);
        setSpacing(true);
        setMargin(true);
        addComponent(home);
        addComponent(createProposal);
        addComponent(accessProposal);
        addComponent(customerInfo);
        addComponent(productCatalogue);
        addComponent(customerSupport);

    }

}
