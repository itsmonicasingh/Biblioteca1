package com.twu.biblioteca;

import java.util.ArrayList;

//Library allows issue and return of Library items i.e Books and movies
public class Library {

    private  ArrayList<LibraryItem> libraryItems;
    private  ArrayList<LibraryItem> checkedOutLibraryItems;

    public Library(ArrayList<LibraryItem> libraryItems, ArrayList<LibraryItem> checkedOutLibraryItems) {
        this.libraryItems = libraryItems;
        this.checkedOutLibraryItems = checkedOutLibraryItems;
    }

    public ArrayList<LibraryItem> getLibraryItems() {
        return libraryItems;
    }

    public boolean checkOutLibraryItem(String itemName) {
        for (LibraryItem libraryItem : libraryItems) {
            if (libraryItem.hasTitle(itemName)) {
                libraryItems.remove(libraryItem);
                checkedOutLibraryItems.add(libraryItem);
                return true;
            }
        }
        return false;
    }

    public boolean checkInLibraryItem(String itemName) {
        for (LibraryItem libraryItem : checkedOutLibraryItems) {
            if (libraryItem.hasTitle(itemName)) {
                checkedOutLibraryItems.remove(libraryItem);
                libraryItems.add(libraryItem);
                return true;
            }
        }
        return false;
    }
}
