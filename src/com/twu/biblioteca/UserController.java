package com.twu.biblioteca;

//Acts as Controller for User and Admin.
public class UserController implements Operations {

    private View view;
    private User user;
    private BibliotecaParser parser;
    private Messages menu;

    public UserController(View view, User user, BibliotecaParser parser, Messages menu) {
        this.view = view;
        this.user = user;
        this.parser = parser;
        this.menu = menu;
    }

    @Override
    public void execute() {
        String userInput;
        do {
            view.show(menu);
            userInput = view.getInput();
            Operations operations = parser.parse(userInput, user);
            operations.execute();
        } while (isLogout(userInput));
    }

    private boolean isLogout(String userInput) {
        return !((userInput.equals("8")));
    }
}