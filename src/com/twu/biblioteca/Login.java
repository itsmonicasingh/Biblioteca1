package com.twu.biblioteca;

import java.util.ArrayList;

public class Login {
    private ArrayList<User> users;
    private View view;


    public Login(ArrayList<User> users, View view) {
        this.users = users;
        this.view = view;
    }

    public User authenticate() {
        view.show(Messages.enterUserName);
        String libraryNo = view.getInput();
        view.show(Messages.enterPassword);
        String password = view.getInput();
        for (User user : users) {
            if (user.match(libraryNo, password))
                return user;
        }
        return null;
    }

    public ArrayList<User> getUsers() {
        return users;
    }
}

