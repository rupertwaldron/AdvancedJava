package com.ruppyrup.errorobjects;

public class User {
    private final String name;

    public User(String name) {
        this.name = name;
    }

    public void showProfile() {
        System.out.println("User name :: " + name);
    }
}
