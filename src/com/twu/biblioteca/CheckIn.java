package com.twu.biblioteca;

//CheckIn returns a book to the library
public class CheckIn implements Operations {

    private View view;
    private Library library;
    private Messages enterItemName;
    private Messages successfulItemCheckIn;
    private Messages unsuccessfulItemCheckIn;
    private User user;

    public CheckIn(View view, Library library, Messages enterItemName, Messages successfulItemCheckIn, Messages unsuccessfulItemCheckIn, User user) {
        this.view = view;
        this.library = library;
        this.enterItemName = enterItemName;
        this.successfulItemCheckIn = successfulItemCheckIn;
        this.unsuccessfulItemCheckIn = unsuccessfulItemCheckIn;
        this.user = user;
    }

    @Override
    public void execute() {
        view.show(enterItemName);
        if (library.checkInLibraryItem(user.getName(), view.getInput())) {
            view.show(successfulItemCheckIn);
        } else {
            view.show(unsuccessfulItemCheckIn);
        }
    }
}