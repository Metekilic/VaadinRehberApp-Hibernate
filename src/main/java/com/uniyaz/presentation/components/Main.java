package com.uniyaz.presentation.components;

import com.vaadin.ui.Alignment;
import com.vaadin.ui.VerticalLayout;

public class Main extends VerticalLayout {

    private Sidebar sidebar;
    private Content content;
    private Body body;
    private Header header;
    private Footer footer;

    public Main(){
        setSizeFull();
        buildLayout();

    }

    private void buildLayout() {

        header = new Header();
        addComponent(header);
        setComponentAlignment(header, Alignment.MIDDLE_CENTER);

        //content = new Content();
        //addComponent(content);
        //setComponentAlignment(content,Alignment.BOTTOM_CENTER);

        body = new Body();
        addComponent(body);
        setComponentAlignment(body,Alignment.BOTTOM_LEFT);

        footer = new Footer();
        addComponent(footer);
        setComponentAlignment(footer,Alignment.MIDDLE_CENTER);



    }
}
