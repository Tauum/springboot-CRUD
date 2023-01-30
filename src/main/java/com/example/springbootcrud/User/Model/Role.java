package com.example.springbootcrud.User.Model;

public enum Role {
    UNDEFINED ("Undefined"),
    USER ("User"),
    STAFF ("Staff"),
    ADMIN ("Admin");

    private final String name;

    Role(String name) {
        this.name = name;
    }
}