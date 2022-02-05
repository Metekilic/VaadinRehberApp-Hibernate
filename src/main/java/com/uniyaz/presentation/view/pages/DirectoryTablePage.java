package com.uniyaz.presentation.view.pages;

import com.uniyaz.core.dao.PersonDao;
import com.uniyaz.core.domain.Person;
import com.vaadin.data.Item;
import com.vaadin.data.Property;
import com.vaadin.data.fieldgroup.BeanFieldGroup;
import com.vaadin.data.util.IndexedContainer;
import com.vaadin.shared.ui.MultiSelectMode;
import com.vaadin.ui.HorizontalLayout;
import com.vaadin.ui.Table;
import com.vaadin.ui.VerticalLayout;

import java.util.List;

public class DirectoryTablePage extends VerticalLayout {

    private Table table;
    private HorizontalLayout horizontalLayout;
    private IndexedContainer indexedContainer;
    private Person personBindObject;
    private BeanFieldGroup<Person> binder;
    private PersonDao personDao = new PersonDao();

    public DirectoryTablePage(){

        buildBinder();
        buildLayout();
        addComponent(horizontalLayout);
        binder = new BeanFieldGroup<Person>(Person.class);
        binder.setItemDataSource(new Person());
    }

    private void buildLayout() {

        buildContainer();
        buildTable();
        fillContainer();
        table.setHeight("250px");

    }

    private void buildTable() {


        horizontalLayout = new HorizontalLayout();

        table = new Table();
        table.setImmediate(true);
        table.setContainerDataSource(indexedContainer);
        table.setSizeFull();

        table.setSelectable(true);
        table.setMultiSelectMode(MultiSelectMode.SIMPLE);
        table.setMultiSelect(false);

        table.setColumnWidth("id", 45);
        table.setColumnWidth("name", 300);
        table.setColumnAlignment("number", Table.Align.LEFT);



        table.setVisibleColumns("id", "name", "number");
        table.setColumnHeaders("ID", "NAME", "NUMBER");

        table.addValueChangeListener(new Property.ValueChangeListener() {
            @Override
            public void valueChange(Property.ValueChangeEvent event) {
                Person selectedItemId = (Person) event.getProperty().getValue();

                if (selectedItemId != null) {
                    setItemDataSource(selectedItemId);
                    //MyUI.getCurrent().setContent(personOperations);
                }
            }
        });

        horizontalLayout.addComponent(table);
    }

    public void buildContainer(){
        indexedContainer = new IndexedContainer();
        indexedContainer.addContainerProperty("id",Long.class,0);
        indexedContainer.addContainerProperty("name",String.class,null);
        indexedContainer.addContainerProperty("number",String.class,null);

    }

    private void fillContainer() {
        getIndexedContainer().removeAllItems();
        List<Person> personList = personDao.findAllPerson();
        for (Person person : personList) {
            Item item = getIndexedContainer().addItem(person);
            item.getItemProperty("id").setValue(person.getId());
            item.getItemProperty("name").setValue(person.getName());
            item.getItemProperty("number").setValue(person.getNumber());
        }
    }

    private void buildBinder() {
        binder = new BeanFieldGroup<Person>(Person.class);
        binder.setItemDataSource(personBindObject);
        binder.bindMemberFields(this);
    }

    public void setItemDataSource(Person person) {
        //idField.setValue(String.valueOf(person.getId()));
        //name.setValue(person.getName());
        //number.setValue(person.getNumber());
        binder.setItemDataSource(person);
        binder.bindMemberFields(this);
    }

    public IndexedContainer getIndexedContainer() {
        return indexedContainer;
    }

    public void setIndexedContainer(IndexedContainer indexedContainer) {
        this.indexedContainer = indexedContainer;
    }

    public Table getTable() {
        return table;
    }

    public void setTable(Table table) {
        this.table = table;
    }

    public HorizontalLayout getHorizontalLayout() {
        return horizontalLayout;
    }

    public void setHorizontalLayout(HorizontalLayout horizontalLayout) {
        this.horizontalLayout = horizontalLayout;
    }

    public Person getPersonBindObject() {
        return personBindObject;
    }

    public void setPersonBindObject(Person personBindObject) {
        this.personBindObject = personBindObject;
    }

    public BeanFieldGroup<Person> getBinder() {
        return binder;
    }

    public void setBinder(BeanFieldGroup<Person> binder) {
        this.binder = binder;
    }

    public PersonDao getPersonDao() {
        return personDao;
    }

    public void setPersonDao(PersonDao personDao) {
        this.personDao = personDao;
    }
}
