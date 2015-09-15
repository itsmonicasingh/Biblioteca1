package com.twu.biblioteca;

//Display displays list of books
public class Display implements Operations {

    private View view;
    private Library library;

    public Display(View view, Library library) {

        this.view = view;
        this.library = library;
    }

    @Override
    public void execute() {
        view.displayListOfLibraryItems(library);
    }
}