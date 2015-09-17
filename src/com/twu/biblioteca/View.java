package com.twu.biblioteca;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

//View displays to console
public class View {

    public String getInput() {
        Scanner scanner = new Scanner(System.in);
        return scanner.nextLine();
    }

    public void show(Messages messages) {
        System.out.println(messages.getMessage());
    }

    public void displayListOfLibraryItems(ArrayList<LibraryItem> libraryItems, Messages listOfItems, Messages itemHeader) {
        System.out.println(listOfItems.getMessage());
        System.out.print(itemHeader.getMessage());
        for (LibraryItem libraryItem : libraryItems) {
            System.out.println(libraryItem);
        }
    }

    public void showUserInformation(User user) {
        System.out.println(user);
    }

    public void displayCheckedOutList(HashMap<LibraryItem, String> CheckedOutLibraryItems, Messages listOfItems, Messages itemHeader) {
        System.out.println(listOfItems.getMessage());
        System.out.print(itemHeader.getMessage());
        for (LibraryItem item : CheckedOutLibraryItems.keySet()) {
            System.out.println(item + " " + CheckedOutLibraryItems.get(item));
        }
    }
}
