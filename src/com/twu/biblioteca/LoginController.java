package com.twu.biblioteca;

//Controller for Admin and Login actions.
public class LoginController implements Operations {

    private BibliotecaParser parser;
    private Login login;

    public LoginController(BibliotecaParser parser, Login login) {
        this.parser = parser;
        this.login = login;
    }

    @Override
    public void execute() {
        User user = login.authenticate();
        Operations operations = parser.parse(user);
        operations.execute();
    }
}