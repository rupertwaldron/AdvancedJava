package com.ruppyrup.patterns.errorobjects;

public class InvalidUser implements UserResult {
    @Override
    public void applyTo(UserConsumer consumer) {
        consumer.invalidUser();
    }
}
