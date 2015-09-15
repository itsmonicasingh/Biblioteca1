package com.twu.biblioteca;

public class BibliotecaParser {

    public Operations parse(String userInput, View view, Library bookLibrary, Library moviesLibrary) {
        if (userInput.equals("0")) {
            return new Quit();
        } else if (userInput.equals("1")) {
            return new Display(view, bookLibrary);
        } else if (userInput.equals("2")) {
            return new CheckOut(view, bookLibrary);
        } else if (userInput.equals("3")) {
            return new CheckIn(view,bookLibrary);
        } else if (userInput.equals("4")) {
            return new Display(view, moviesLibrary);
        }
        else {
            return new InvalidOption(view);
        }
    }
}
