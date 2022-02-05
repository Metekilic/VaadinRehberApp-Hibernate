package com.uniyaz.presentation.components;

import com.vaadin.ui.Alignment;
import com.vaadin.ui.Label;
import com.vaadin.ui.VerticalLayout;

public class Content extends VerticalLayout {

    public Content(){

        buildLayout();

    }

    private void buildLayout() {

        setSizeFull();
        Label lbl = new Label("Rehber Programına Hoşgeldiniz");
        addComponent(lbl);
    }
}
