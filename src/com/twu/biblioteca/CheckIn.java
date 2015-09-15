package com.twu.biblioteca;

//CheckIn returns a book to the library
public class CheckIn implements Operations {

    private View view;
    private Library library;
    private Messages enterItemName;
    private Messages successfulItemCheckIn;
    private Messages unsuccessfulItemCheckIn;

    public CheckIn(View view, Library library, Messages enterItemName, Messages successfulItemCheckIn, Messages unsuccessfulItemCheckIn) {
        this.view = view;
        this.library = library;
        this.enterItemName = enterItemName;
        this.successfulItemCheckIn = successfulItemCheckIn;
        this.unsuccessfulItemCheckIn = unsuccessfulItemCheckIn;
    }

    @Override
    public void execute() {
        view.show(enterItemName);
        if (library.checkInLibraryItem(view.getInput())) {
            view.show(successfulItemCheckIn);
        } else {
            view.show(unsuccessfulItemCheckIn);
        }
    }
}