package com.twu.biblioteca;

import java.util.ArrayList;
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
}
