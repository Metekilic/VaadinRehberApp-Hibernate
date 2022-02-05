package com.uniyaz.presentation.components;

import com.uniyaz.presentation.view.pages.DirectoryAddPage;
import com.uniyaz.presentation.view.pages.DirectoryTablePage;
import com.vaadin.server.FontAwesome;
import com.vaadin.ui.*;

public class Sidebar extends VerticalLayout {

    private Button personTableButton;
    private Button personAddTableButton;
    private Content content;
    private DirectoryAddPage directoryAddPage;
    private DirectoryTablePage directoryTablePage;

    public Sidebar(){
        buildLayout();

        buildPersonAddTable();
        setMargin(true);
        addComponent(personAddTableButton);
        //setComponentAlignment(personAddTableButton,Alignment.MIDDLE_CENTER);
        buildPersonTable();
        addComponent(personTableButton);
        //setComponentAlignment(personTableButton,Alignment.MIDDLE_CENTER);
    }

    private void buildLayout() {
        setWidth("200px");
        setSpacing(true);
        //setSizeFull();
        setCaption("Menü");
        //setComponentAlignment(,Alignment.MIDDLE_CENTER);
        //setHeight("500px");




    }

    private Button buildPersonAddTable(){

        personAddTableButton = new Button();
        personAddTableButton.setWidth(200,Unit.PIXELS);
        personAddTableButton.setCaption("Add Person");
        personAddTableButton.setIcon(FontAwesome.PLUS);
        personAddTableButton.addClickListener(new Button.ClickListener() {
            @Override
            public void buttonClick(Button.ClickEvent clickEvent) {
                content.removeAllComponents();

                //Label lll = new Label("persontable");
                directoryAddPage = new DirectoryAddPage();
                content.addComponent(directoryAddPage);

            }
        });

        return personAddTableButton;
    }


    private Button buildPersonTable() {

        personTableButton = new Button();
        personTableButton.setWidth(200,Unit.PIXELS);
        personTableButton.setCaption("Open Dictionary");
        personTableButton.setIcon(FontAwesome.TABLE);
        personTableButton.addClickListener(new Button.ClickListener() {
            @Override
            public void buttonClick(Button.ClickEvent clickEvent) {
                content.removeAllComponents();

                directoryTablePage = new DirectoryTablePage();
                content.addComponent(directoryTablePage);

            }
        });

        return personTableButton;

    }

    public void setContent(Content content) {
        this.content = content;
    }
}
