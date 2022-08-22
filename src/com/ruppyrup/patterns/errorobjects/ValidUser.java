package com.ruppyrup.patterns.errorobjects;

public class ValidUser  implements UserResult {
    private final User user;

    public ValidUser(User user) {
        this.user = user;
    }

    @Override
    public void applyTo(UserConsumer consumer) {
        consumer.validUser(user);
    }
}
