package com.uniyaz.presentation.components;

import com.vaadin.ui.Alignment;
import com.vaadin.ui.HorizontalLayout;
import com.vaadin.ui.Label;
import com.vaadin.ui.VerticalLayout;

public class Header extends HorizontalLayout {

    private Label label;

    public Header (){

        buildLayout();

    }

    private void buildLayout() {

        label = new Label("Rehber Programı");
        addComponent(label);


    }

}
