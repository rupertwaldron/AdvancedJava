package com.ruppyrup.patterns.adapter;

public class User implements UserAble{
    private Employee employee;

    public User(Employee employee) {
        this.employee = employee;
    }

    @Override
    public int getAge() {
        return employee.getAge();
    }

    @Override
    public String getName() {
        return employee.getName();
    }

    @Override
    public String toString() {
        return "User{" +
                "name=" + getName() + "\n" + "age=" + getAge() +
                '}';
    }
}
