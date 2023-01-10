package com.ruppyrup.solid.SRP;

/*
 A class should have one reason to change
 Look to test to check if they talk about the same thing
*/

public class Firework {
    private final String name;
    private final int power;
    private boolean live = true;

    public Firework(final String name, final int power) {
        this.name = name;
        this.power = power;
    }

    public void goOff() {
        if (live) {
            System.out.println(name + " has exploded with power " + power);
            live = false;
            return;
        }
        throw new IllegalStateException("The firework is dead!");
    }

    public static void main(String[] args) {
        Firework firework = new Firework("rocket", 3);
        firework.goOff();
        firework.goOff();

    }
}
