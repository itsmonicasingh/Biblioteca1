package com.twu.biblioteca;

import java.util.ArrayList;

//Display List of Users.
public class DisplayListOfUsers implements Operations {
    private View view;
    private ArrayList<User> users;
    private Messages listOfUsers;
    private Messages userHeader;

    public DisplayListOfUsers(View view, ArrayList<User> users, Messages listOfUsers, Messages userHeader) {
        this.view = view;
        this.users = users;
        this.listOfUsers = listOfUsers;
        this.userHeader = userHeader;
    }

    @Override
    public void execute() {
        view.displayListOfUsers(users, listOfUsers, userHeader);
    }
}