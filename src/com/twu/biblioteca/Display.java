package com.twu.biblioteca;

import java.util.ArrayList;

//Display displays list of books
public class Display implements Operations {

    private View view;
    private ArrayList<LibraryItem> libraryItems;
    private Messages listOfItems;
    private Messages itemHeader;

    public Display(View view, ArrayList<LibraryItem> libraryItems, Messages listOfItems, Messages itemHeader) {
        this.view = view;
        this.libraryItems = libraryItems;
        this.listOfItems = listOfItems;
        this.itemHeader = itemHeader;
    }

    @Override
    public void execute() {
        view.displayListOfLibraryItems(libraryItems, listOfItems, itemHeader);
    }
}