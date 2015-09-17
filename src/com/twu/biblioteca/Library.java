package com.twu.biblioteca;

import java.util.ArrayList;
import java.util.HashMap;

//Library allows issue and return of Library items i.e Books and movies
public class Library {

    private  ArrayList<LibraryItem> libraryItems;
    private HashMap<LibraryItem, String> checkedOutLibraryItems;

    public Library(ArrayList<LibraryItem> libraryItems, HashMap<LibraryItem, String> checkedOutLibraryItems) {
        this.libraryItems = libraryItems;
        this.checkedOutLibraryItems = checkedOutLibraryItems;
    }

    public ArrayList<LibraryItem> getLibraryItems() {
        return libraryItems;
    }

    public boolean checkOutLibraryItem(String user, String itemName) {
        for (LibraryItem libraryItem : libraryItems) {
            if (libraryItem.hasTitle(itemName)) {
                libraryItems.remove(libraryItem);
                checkedOutLibraryItems.put(libraryItem, user);
                return true;
            }
        }
        return false;
    }

    public boolean checkInLibraryItem(String user, String itemName) {
        for (LibraryItem libraryItem : checkedOutLibraryItems.keySet()) {
            if (libraryItem.hasTitle(itemName) && user.equals(checkedOutLibraryItems.get(libraryItem))) {
                checkedOutLibraryItems.remove(libraryItem);
                libraryItems.add(libraryItem);
                return true;
            }
        }
        return false;
    }

    public HashMap<LibraryItem, String> getCheckedOutLibraryItems() {
        return checkedOutLibraryItems;
    }
}
