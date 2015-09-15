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

    public void displayListOfBooks(Library library) {
        System.out.println("List of Books");
        System.out.printf("%-15s %-15s %-5s\n","Title","Author","Year Of Publication");

        for (Book book : library.getBooks()) {
            System.out.println(book);
        }
    }



    public void displayInvalidOption() {
        System.out.println("Select a valid option!");
    }

    public void displayMenu() {
        System.out.println("[0] Quit");
        System.out.println("[1] List Books");
        System.out.println("[2] Checkout Book");
        System.out.println("[3] CheckIn Book");
    }

    public void displaySuccessfulCheckout() {
        System.out.println("Thank you! Enjoy the book");
    }

    public void displayUnSuccessfulCheckout() {
        System.out.println("That book is not available.");
    }

    public void displaySuccessfulCheckIn() {
        System.out.println("Thank you for returning the book.");
    }

    public void displayUnSuccessfulCheckIn() {
        System.out.println("That is not a valid book to return.");
    }
}
