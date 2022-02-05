package com.uniyaz.core.domain;

import org.hibernate.annotations.Table;

import javax.persistence.*;

@Entity
public class Person {

    @Id
    @Column
    @GeneratedValue(strategy = GenerationType.AUTO,generator = "generator")
    private Long id;

    @Column
    private String name;

    @Column
    private String number;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }
}
