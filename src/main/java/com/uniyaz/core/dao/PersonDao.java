package com.uniyaz.core.dao;

import com.uniyaz.utils.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;
import com.uniyaz.core.domain.Person;

import java.util.ArrayList;
import java.util.List;

public class PersonDao {

    List<Person> personList = new ArrayList<Person>();

    public List<Person> findAllPerson() {
        List<Person> personList = new ArrayList<Person>();
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction transaction = session.beginTransaction();

        String hql = " Select person From  Person person ";
        Query query = session.createQuery(hql);
        personList = query.list();

        transaction.commit();
        session.close();

        return personList;
    }

    public Boolean savePerson(Person person) {

        try {
            person.setId(1L);
            person.setName(person.getName());
            person.setNumber(person.getNumber());

            Session session = HibernateUtil.getSessionFactory().openSession();
            Transaction transaction = session.beginTransaction();
            session.save(person);
            transaction.commit();
            session.close();
            return true;
        } catch (Exception e) {

        }

        return false;
    }

    public Boolean deletePerson(Person person) {

        try {

            Session session = HibernateUtil.getSessionFactory().openSession();
            Transaction transaction = session.beginTransaction();

            session.delete(session.get(Person.class, person.getId()));
            transaction.commit();
            session.close();

            return true;

        } catch (Exception e) {


        }
        return false;
    }

    public Boolean updatePerson(Person person) {

        try {

            Session session = HibernateUtil.getSessionFactory().openSession();
            Transaction transaction = session.beginTransaction();

            person = session.get(Person.class, person.getId());
            person.setName(person.getName());
            person.setNumber(person.getNumber());
            session.update(person);

            transaction.commit();
            session.close();

            return true;


        } catch (Exception e) {


        }
        return false;
    }

    public boolean findAdressById(Person person){

        try {
            Session session = HibernateUtil.getSessionFactory().openSession();
            Transaction transaction = session.beginTransaction();

            person = session.get(Person.class,person.getId());

            String hql = "Select person From  Person person Where id = ?";
            Query query = session.createQuery(hql);
            personList = query.list();

            return true;

        }catch (Exception e){}
        return false;
    }


}
