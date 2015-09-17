package com.twu.biblioteca;

//Displays user information
public class DisplayUserInformation implements Operations {

    private View view;
    private User user;

    public DisplayUserInformation(View view, User user) {
        this.view = view;
        this.user = user;
    }

    @Override
    public void execute() {
        view.showUserInformation(user);
    }
}