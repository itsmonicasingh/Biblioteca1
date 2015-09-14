package com.twu.biblioteca;

public class BibliotecaParser {

    public Operations parse(String userInput, View view, Library library) {
        if (userInput.equals("0")) {
            return new Quit();
        } else if (userInput.equals("1")) {
            return new DisplayBooks(view, library);
        } else if (userInput.equals("2")) {
            return new CheckOut(view, library);
        } else if (userInput.equals("3")) {
            return new CheckIn(view,library);
        }
        else {
            return new InvalidOption(view);
        }
    }
}
