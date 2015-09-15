package com.twu.biblioteca;


public class BibliotecaController {

    private View view;
    private Library library;

    public BibliotecaController(View view, Library library) {
        this.view = view;
        this.library = library;
    }

    public void start() {
        view.show(Messages.welcome);
        String userInput;
        while (true) {
            view.displayMenu();
            userInput = view.getInput();
            BibliotecaParser parser = new BibliotecaParser();
            Operations operation = parser.parse(userInput,view,library);
            operation.execute();
        }
    }
}