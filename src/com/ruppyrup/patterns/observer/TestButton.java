package com.ruppyrup.patterns.observer;

public class TestButton {
    public static void main(String[] args) {
        Person bob = new Person(90, "Bob");
        Person trev = new Person(120, "Trev");
        Monster goblin = new Monster(80, "goblin");

        Button attack = new Button();

        attack.register(goblin);
        attack.register(trev);
        attack.register(bob);

        goblin.canSeePerson(trev);
        goblin.canSeePerson(bob);

        attack.onClick();


    }
}
