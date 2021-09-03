package com.ruppyrup.collectingparameters;

import java.util.ArrayList;
import java.util.List;

public class TestCollectingMetrics {
    public static void main(String[] args) {
        User u1 = new User(26, true);
        User u2 = new User(15, false);
        User u3 = new User(50, true);
        User u4 = new User(36, false);
        User u5 = new User(29, true);

        Users users = new Users();
        users.add(u1);
        users.add(u2);
        users.add(u3);
        users.add(u4);
        users.add(u5);

        UserMetrics userMetrics = new UserMetrics();

        users.collect(userMetrics);

        Display display = new Display();

        userMetrics.display(display);

    }
}


class Users {
    private final List<User> users = new ArrayList<>();

    public void add(User user) {
        users.add(user);
    }

    public void collect(UserMetrics metrics) {
        users.forEach(user -> user.reportMetrics(metrics));
    }
}
