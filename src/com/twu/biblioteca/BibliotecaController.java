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
            view.displayMenu();
            userInput = view.getInput();

            if (userInput.equals("0")) {
                return;
            } else if (userInput.equals("1")) {
                view.displayListOfBooks(library);

            } else if (userInput.equals("2")) {
                library.checkOutBook(view.getInput());

            } else {
                view.displayInvalidOption();
            }
        }
    }
}