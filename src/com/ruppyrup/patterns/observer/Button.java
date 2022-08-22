package com.ruppyrup.patterns.observer;

import java.util.ArrayList;
import java.util.List;

interface Actionable {
    void doAction();
}

class Button {
    private final List<Actionable> observers = new ArrayList<>();

    void register(Actionable a) {
        observers.add(a);
    }

    void onClick() {
        observers.forEach(Actionable::doAction);
    }
}

interface Attack {
    void attack();
}

abstract class Character implements Actionable {
    private int health;
    private final String name;

    public Character(int health, String name) {
        this.health = health;
        this.name = name;
    }


    void updateHealth(int x) {
        health += x;
        System.out.println(name + " now has " + health);
    }


    public int getHealth() {
        return health;
    }

    public String getName() {
        return name;
    }

    @Override
    public String toString() {
        return "Character{" +
                "health=" + health +
                ", name='" + name + '\'' +
                '}';
    }
}

class Monster extends Character implements Attack {
    private int strength = 10;
    private List<Character> nearByPeople = new ArrayList<>();

    public Monster(int health, String name) {
        super(health, name);
    }

    public void canSeePerson(Character person) {
        nearByPeople.add(person);
    }

    @Override
    public void attack() {
         nearByPeople.forEach(person -> person.updateHealth(-strength));
    }

    @Override
    public void doAction() {
        attack();
    }
}

class Person extends Character {

    public Person(int health, String name) {
        super(health, name);
    }

    @Override
    public void doAction() {
        System.out.println("Help " + getName() + " is being attacked!!");
        System.out.println(getName() + " now has health :: " + getHealth());
    }
}
