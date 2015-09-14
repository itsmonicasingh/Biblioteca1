package com.twu.biblioteca;

//CheckOut issues a book from the library
public class CheckOut implements Operations {

    private View view;
    private Library library;

    public CheckOut(View view, Library library) {

        this.view = view;
        this.library = library;
    }

    @Override
    public void execute() {

        if (library.checkOutBook(view.getInput())) {
            view.displaySuccessfulCheckout();
        }
        else {
            view.displayUnSuccessfulCheckout();
        }
    }

}