package com.twu.biblioteca;

import java.util.HashMap;

//Displays the list of checked out items
public class DisplayCheckedOutList implements Operations {
    private View view;
    private HashMap<LibraryItem, String> checkedOutLibraryItems;
    private Messages listOfItems;
    private Messages itemHeader;

    public DisplayCheckedOutList(View view, HashMap<LibraryItem, String> checkedOutItems, Messages listOfItems, Messages itemHeader) {
        this.view = view;
        this.checkedOutLibraryItems = checkedOutItems;
        this.listOfItems = listOfItems;
        this.itemHeader = itemHeader;
    }

    @Override
    public void execute() {
        view.displayCheckedOutList(checkedOutLibraryItems, listOfItems, itemHeader);
    }
}

