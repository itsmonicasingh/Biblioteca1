package com.twu.biblioteca;

public class CheckOut implements Operations {
    private View view;
    private Library library;

    public CheckOut(View view, Library library) {

        this.view = view;
        this.library = library;
    }

    @Override
    public void execute() {

        boolean checkout = library.checkOutBook(view.getInput());
        if (checkout) {
            view.displaySuccessfulCheckout();
        }
    }

}