package com.twu.biblioteca;

public class CheckIn implements Operations {
    private View view;
    private Library library;

    public CheckIn(View view, Library library) {

        this.view = view;
        this.library = library;
    }

    @Override
    public void execute() {
        library.checkInBook(view.getInput());
    }
}