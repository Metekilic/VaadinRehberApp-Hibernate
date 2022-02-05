package com.uniyaz.presentation.view.pages;

import com.uniyaz.core.domain.Person;
import com.uniyaz.core.dao.PersonDao;
import com.uniyaz.presentation.components.Content;
import com.vaadin.ui.*;

public class DirectoryAddPage extends VerticalLayout {

    private HorizontalLayout horizontalLayout;
    private TextField nameTF;
    private TextField numberTF;
    private Button addBtn;
    private Table table;
    private DirectoryTablePage directoryTablePage;
    private Content content;
    PersonDao personDao = new PersonDao();


    public DirectoryAddPage() {
        buildLayout();
        addComponent(horizontalLayout);
        setComponentAlignment(horizontalLayout,Alignment.BOTTOM_CENTER);

    }

    private void buildLayout() {

        horizontalLayout = new HorizontalLayout();
        horizontalLayout.setSpacing(true);

        nameTF = new TextField("name");
        horizontalLayout.addComponent(nameTF);

        numberTF = new TextField("number");
        horizontalLayout.addComponent(numberTF);

        addBtn = new Button("Add Person");
        addBtn.addClickListener(new Button.ClickListener() {
            @Override
            public void buttonClick(Button.ClickEvent clickEvent) {
                buildAddButton();

            }
        });
        horizontalLayout.addComponent(addBtn);


    }

    private void buildAddButton() {
        Person person = new Person();
        person.setName(getNameTF().getValue());
        person.setNumber(getNumberTF().getValue());
        boolean isInserted = personDao.savePerson(person);
        System.out.println(isInserted);
    }



    public TextField getNameTF() {
        return nameTF;
    }

    public void setNameTF(TextField nameTF) {
        this.nameTF = nameTF;
    }

    public TextField getNumberTF() {
        return numberTF;
    }

    public void setNumberTF(TextField numberTF) {
        this.numberTF = numberTF;
    }

    public Content getContent() {
        return content;
    }

    public void setContent(Content content) {
        this.content = content;
    }
}