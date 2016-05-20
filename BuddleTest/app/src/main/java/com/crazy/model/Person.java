package com.crazy.model;

import java.io.Serializable;

/**
 * Created by swolf on 16/5/6.
 */

public class Person implements Serializable{
    private static final long serialVersionUID = 0;

    private Integer id;
    private String name;
    private String pass;
    private String gender;

    public Person(String name, String pass, String gender) {
        this.name = name;
        this.pass = pass;
        this.gender = gender;
    }

    public Integer getId() {
        return this.id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPass() {
        return this.pass;
    }

    public void setPass(String pass) {
        this.pass = pass;
    }

    public String getGender() {
        return this.gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }
}
