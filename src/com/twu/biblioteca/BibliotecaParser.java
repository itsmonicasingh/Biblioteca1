package com.twu.biblioteca;

public class BibliotecaParser {

    public Operations parse(String userInput, View view, Library library) {
        if (userInput.equals("1")) {
            return new DisplayBooks(view, library);
        }
        return null;
    }
}
