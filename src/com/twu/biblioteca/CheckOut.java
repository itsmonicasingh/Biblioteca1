package com.twu.biblioteca;

//CheckOut issues a book from the library
public class CheckOut implements Operations {

    private View view;
    private Library library;
    private Messages enterItemName;
    private Messages successfulItemCheckout;
    private Messages unsuccessfulItemCheckOut;
    private User user;

    public CheckOut(View view, Library library, Messages enterItemName, Messages successfulItemCheckout, Messages unsuccessfulItemCheckOut, User user) {
        this.view = view;
        this.library = library;
        this.enterItemName = enterItemName;
        this.successfulItemCheckout = successfulItemCheckout;
        this.unsuccessfulItemCheckOut = unsuccessfulItemCheckOut;
        this.user = user;
    }

    @Override
    public void execute() {
        view.show(enterItemName);
        if (library.checkOutLibraryItem(user.getName(), view.getInput())) {
            view.show(successfulItemCheckout);
        } else {
            view.show(unsuccessfulItemCheckOut);
        }
    }
}