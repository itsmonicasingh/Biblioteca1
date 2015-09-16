package com.twu.biblioteca;

import java.util.ArrayList;

public class Login {
    private final ArrayList<User> users;
    private final View view;

    public Login(ArrayList<User> users, View view) {
        this.users = users;
        this.view = view;
    }

    public User authenticate() {
        String libraryNo = view.getInput();
        String password = view.getInput();
        for (User user : users) {
            if (user.match(libraryNo, password))
                return user;
        }
        return null;
    }
}
