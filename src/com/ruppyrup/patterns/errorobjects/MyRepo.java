package com.ruppyrup.patterns.errorobjects;

import java.util.HashMap;
import java.util.Map;

public class MyRepo implements Repo {
    private Map<String, User> users = new HashMap<>();

    @Override
    public UserResult findUserById(String id) {
        User user = users.get(id);
        return user != null ? new ValidUser(user) : new InvalidUser();
    }

    @Override
    public void saveUserById(String id, User user) {
        users.put(id, user);
    }
}
