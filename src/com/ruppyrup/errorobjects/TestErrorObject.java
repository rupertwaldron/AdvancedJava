package com.ruppyrup.errorobjects;

public class TestErrorObject {
    public static void main(String[] args) {
        ProfileTextDisplay display = new ProfileTextDisplay();

        Repo userRepo = new MyRepo();

        User bob = new User("Bob");

        userRepo.saveUserById("29", bob);

        UserResult ur1 = userRepo.findUserById("29");
        UserResult ur2 = userRepo.findUserById("28");

        ur1.applyTo(display);
        ur2.applyTo(display);

    }
}
