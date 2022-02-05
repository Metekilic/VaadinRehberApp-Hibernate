package com.uniyaz.presentation.components;

import com.vaadin.ui.Alignment;
import com.vaadin.ui.HorizontalLayout;
import com.vaadin.ui.VerticalLayout;

public class Body extends HorizontalLayout {

    public Body(){

        setSizeFull();

        Sidebar sidebar = new Sidebar();
        addComponent(sidebar);

        Content content = new Content();
        addComponent(content);
        setComponentAlignment(content,Alignment.MIDDLE_CENTER);

        sidebar.setContent(content);

    }
}
