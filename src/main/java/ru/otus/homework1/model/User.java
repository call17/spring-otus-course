package ru.otus.homework1.model;

public class User {
    private String name;
    private String lastName;

    public void setName(String name) {
        this.name = name;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    @Override
    public String toString() {
        return "Name : " + name + "\nLastName : " + lastName;
    }
}
