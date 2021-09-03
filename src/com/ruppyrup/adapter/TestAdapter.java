package com.ruppyrup.adapter;

public class TestAdapter {
    public static void main(String[] args) {
        Employee employee = new Employee("Rupert", "ads", 50);
        User me = new User(employee);
        System.out.println(me);
    }
}
