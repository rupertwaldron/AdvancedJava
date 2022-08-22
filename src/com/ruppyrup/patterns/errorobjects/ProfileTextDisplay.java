package com.ruppyrup.patterns.errorobjects;

public class ProfileTextDisplay implements UserConsumer {
    @Override
    public void validUser(User user) {
        user.showProfile();
    }

    @Override
    public void invalidUser() {
        System.out.println("We don't know that user");
    }
}
