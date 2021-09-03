package com.ruppyrup.errorobjects;

public interface Repo {
    UserResult findUserById(String id);
    void saveUserById(String id, User user);
}
