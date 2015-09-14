package com.twu.biblioteca;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.ArrayList;

import static org.junit.Assert.assertEquals;

public class ViewTest {
    private final ByteArrayOutputStream outContent = new ByteArrayOutputStream();
    PrintStream original;

    @Before
    public void setUpStreams() {
        original = System.out;
        System.setOut(new PrintStream(outContent));
    }

    @Test
    public void shouldShowWelcomeMessage() {
        View view = new View();
        view.welcomeMessage();
        assertEquals("Welcome to Biblioteca\n", outContent.toString());
    }

    @Test
    public void shouldReturnTheBookDetailsOfTheBooksInTheLibrary() {
        View view = new View();
        ArrayList<Book> listOfBooks = new ArrayList<Book>();
        ArrayList<Book> checkOutBooks = new ArrayList<Book>();
        listOfBooks.add(new Book("Alchemist", "Paulo Coelho", "2006"));
        listOfBooks.add(new Book("Dracula", "Bram Stoker", "1998"));
        listOfBooks.add(new Book("Sixth Sense", "M Night", "1999"));
        Library library = new Library(listOfBooks, checkOutBooks);
        view.displayListOfBooks(library);

        assertEquals("List of Books\n" + String.format("%-15s %-15s %-5s\n", "Title", "Author", "Year Of Publication") +
                String.format("%-15s %-15s %-5s\n", "Alchemist", "Paulo Coelho", 2006) +
                String.format("%-15s %-15s %-5s\n", "Dracula", "Bram Stoker", 1998) +
                String.format("%-15s %-15s %-5s\n", "Sixth Sense", "M Night", 1999), outContent.toString());
    }

    @Test
    public void shouldDisplayInvalidOption() {
        View view = new View();

        view.displayInvalidOption();

        assertEquals("Select a valid option!\n",outContent.toString());
    }

    @Test
    public void shouldDisplayMenuOptions() {
        View view = new View();

        view.displayMenu();

        assertEquals("[0] Quit\n[1] List Books\n[2] Checkout Book\n[3] CheckIn Book\n", outContent.toString());
    }

    @Test
    public void shouldDisplaySuccessfulCheckout() {
        View view = new View();

        view.displaySuccessfulCheckout();

        assertEquals("Thank you! Enjoy the book\n", outContent.toString());
    }

    @Test
    public void shouldDisplayUnSuccessfulCheckout() {
        View view = new View();

        view.displayUnSuccessfulCheckout();

        assertEquals("That book is not available.\n", outContent.toString());
    }

    @Test
    public void shouldDisplaySuccessfulCheckIn() {
        View view = new View();

        view.displaySuccessfulCheckIn();

        assertEquals("Thank you for returning the book.\n", outContent.toString());
    }

    @Test
    public void shouldDisplayUnSuccessfulCheckIn() {
        View view = new View();

        view.displayUnSuccessfulCheckIn();

        assertEquals("That is not a valid book to return.\n", outContent.toString());
    }

    @After
    public void cleanUpStreams() {
        System.setOut(original);
    }
}
