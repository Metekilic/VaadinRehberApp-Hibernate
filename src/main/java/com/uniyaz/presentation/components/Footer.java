package com.uniyaz.presentation.components;

import com.vaadin.ui.Alignment;
import com.vaadin.ui.HorizontalLayout;
import com.vaadin.ui.Label;

public class Footer extends HorizontalLayout {

    private Label label;

    public Footer(){

        buildLayout();

    }

    private void buildLayout() {

        label = new Label("Footer Part");
        addComponent(label);
        //setComponentAlignment(label, Alignment.BOTTOM_CENTER);

    }

}
