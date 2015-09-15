package com.twu.biblioteca;

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

    public void displayListOfLibraryItems(Library library) {
        System.out.println("List of Books");
        System.out.printf("%-15s %-15s %-5s\n", "Title", "Author", "Year Of Publication");
        for (LibraryItem libraryItem : library.getLibraryItems()) {
            System.out.println(libraryItem);
        }
    }
}
