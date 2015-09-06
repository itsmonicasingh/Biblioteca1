package com.twu.biblioteca;


public class BibliotecaController {

    private final View view;
    private final Library library;

    public BibliotecaController(View view, Library library) {
        this.view = view;
        this.library = library;
    }

    public void start() {
        view.welcomeMessage();
        String userInput;
        while (true) {
            userInput = view.getInput();

            if (userInput.equals("1")) {
                view.displayListOfBooks(library);

            } else if (userInput.equals("Quit")) {
                return;
            } else {
                view.displayInvalidOption();
            }
        }
    }
}