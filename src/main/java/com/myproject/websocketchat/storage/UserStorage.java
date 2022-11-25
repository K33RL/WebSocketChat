package com.myproject.websocketchat.storage;

import java.util.HashSet;
import java.util.Set;

//TODO переделать с добавление БД
public class UserStorage {
    private static UserStorage instance;
    private Set<String> users;

    private UserStorage() {
        users = new HashSet<>();
    }

    public static synchronized UserStorage getInstance() {
        if (instance == null) {
            instance = new UserStorage();
        }
        return instance;
    }

    public Set<String> getUser() {
        return users;
    }

    public void setUser(String name) throws Exception {
        if (users.contains(name)) {
            throw new Exception(String.format("User with name: %s already exist", name));
        }
        users.add(name);
    }
}
