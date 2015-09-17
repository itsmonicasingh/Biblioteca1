package com.twu.biblioteca;


//Gives Incorrect Login Message
public class IncorrectLogin implements Operations {
    private final View view;

    public IncorrectLogin(View view) {
        this.view = view;
    }

    @Override
    public void execute() {
        view.show(Messages.errorInLogin);
    }
}