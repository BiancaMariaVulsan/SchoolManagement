package com.bianca.Models;

public abstract class Person {

    private String id;
    private String name;
    private String address;

    public Person(String id, String name, String address) {
        this.id = id;
        this.name = name;
        this.address = address;
    }

    public Person(String name, String address) {
        this.name = name;
        this.address = address;
    }
    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public char getFirstLetterName() {
        return name.charAt(0);
    }

    public void setId(String id) {
        this.id = id;
    }
}
