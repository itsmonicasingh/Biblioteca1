package com.twu.biblioteca;

//controls the application
public class BibliotecaController {

    private View view;
    private BibliotecaParser parser;

    public BibliotecaController(View view, BibliotecaParser parser) {
        this.view = view;
        this.parser = parser;
    }

    public void start() {
        view.show(Messages.welcome);
        while (true) {
            view.show(Messages.loginMenu);
            Operations operation = parser.parse(view.getInput());
            operation.execute();
        }
    }
}