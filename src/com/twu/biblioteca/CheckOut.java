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

        view.show(Messages.enterBookName);
        if (library.checkOutLibraryItem(view.getInput())) {
            view.show(Messages.successfulBookCheckout);
        } else {
            view.show(Messages.unsuccessfulBookCheckOut);
        }
    }

}