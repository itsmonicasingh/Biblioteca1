package com.twu.biblioteca;


public class BibliotecaController {

    private View view;
    private Library bookLibrary;
    private Library moviesLibrary;

    public BibliotecaController(View view, Library bookLibrary, Library moviesLibrary) {
        this.view = view;
        this.bookLibrary = bookLibrary;
        this.moviesLibrary = moviesLibrary;
    }

    public void start() {
        view.show(Messages.welcome);
        String userInput;
        while (true) {
            view.show(Messages.menu);
            userInput = view.getInput();
            BibliotecaParser parser = new BibliotecaParser();
            Operations operation = parser.parse(userInput, view, bookLibrary, moviesLibrary);
            operation.execute();
        }
    }
}