package com.twu.biblioteca;

//CheckIn returns a book to the library
public class CheckIn implements Operations {

    private View view;
    private Library library;

    public CheckIn(View view, Library library) {

        this.view = view;
        this.library = library;
    }

    @Override
    public void execute() {
        view.show(Messages.enterBookName);
        if (library.checkInLibraryItem(view.getInput())) {
            view.show(Messages.successfulBookCheckIn);
        } else {
            view.show(Messages.unsuccessfulBookCheckIn);
        }
    }
}