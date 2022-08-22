package com.ruppyrup.patterns.errorobjects;

public interface Repo {
    UserResult findUserById(String id);
    void saveUserById(String id, User user);
}
