package com.twu.biblioteca;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.HashMap;

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
        view.show(Messages.welcome);
        assertEquals("Welcome to Biblioteca\n", outContent.toString());
    }

    @Test
    public void shouldDisplayListOfBooks() {
        View view = new View();
        ArrayList<LibraryItem> books = new ArrayList<LibraryItem>();
        HashMap<LibraryItem, String> checkedBooks = new HashMap<LibraryItem, String>();
        books.add(new Book("Alchemist", "Paulo Coelho", "2006"));
        books.add(new Book("Dracula", "Bram Stoker", "1998"));
        Library bookLibrary = new Library(books, checkedBooks);

        view.displayListOfLibraryItems(bookLibrary.getLibraryItems(), Messages.listOfBooks, Messages.booksHeader);

        assertEquals("List of Books\n" + String.format("%-15s %-15s %-5s\n", "Title", "Author", "Year Of Publication") +
                String.format("%-15s %-15s %-15s\n", "Alchemist", "Paulo Coelho", 2006) +
                String.format("%-15s %-15s %-15s\n", "Dracula", "Bram Stoker", 1998) , outContent.toString());
    }

    @Test
    public void shouldDisplayInvalidOption() {
        View view = new View();

        view.show(Messages.invalidOption);

        assertEquals("Select a valid option!\n",outContent.toString());
    }

    @Test
    public void shouldDisplayMenuOptions() {
        View view = new View();

        view.show(Messages.menu);

        assertEquals("\nMenu\n" + "[0] Quit\n" + "[1] List Books\n" + "[2] List Books\n" + "[3] Checkout Book\n" + "[4] CheckIn Book\n" +
                "[5] List Movies\n" + "[6] List Movies\n" + "[7] CheckOut Movie\n" + "[8] CheckIn Movie\n" +
                "Enter Your Option :\n", outContent.toString());
    }

    @Test
    public void shouldDisplaySuccessfulCheckout() {
        View view = new View();

        view.show(Messages.successfulBookCheckout);

        assertEquals("Thank you! Enjoy the book\n", outContent.toString());
    }

    @Test
    public void shouldDisplayUnSuccessfulCheckout() {
        View view = new View();

        view.show(Messages.unsuccessfulBookCheckOut);

        assertEquals("That book is not available.\n", outContent.toString());
    }

    @Test
    public void shouldDisplaySuccessfulCheckIn() {
        View view = new View();

        view.show(Messages.successfulBookCheckIn);

        assertEquals("Thank you for returning the book.\n", outContent.toString());
    }

    @Test
    public void shouldDisplayUnSuccessfulCheckIn() {
        View view = new View();

        view.show(Messages.unsuccessfulBookCheckIn);

        assertEquals("That is not a valid book to return.\n", outContent.toString());
    }

    @Test
    public void shouldDisplayUserInformation() {
        View view = new View();
        User user = new User("Monica", "monicas@thoughtworks.com", "9448056963", "123-4567", "monica");

        view.showUserInformation(user);

        assertEquals("Monica monicas@thoughtworks.com 9448056963\n", outContent.toString());
    }

    @Test
    public void shouldDisplayCheckedOutList() {
        View view = new View();
        HashMap<LibraryItem, String> checkedOutItems = new HashMap<LibraryItem, String>();
        Movie movie1 = new Movie("Titanic", "1997", "James Cameron", "7.7");

        checkedOutItems.put(movie1, "Monica");
        view.displayCheckedOutList(checkedOutItems, Messages.listOfCheckedOutMovies, Messages.checkedOutMoviesHeader);

        assertEquals("List of CheckedOutMovies\n" +
                String.format("%-15s %-15s %-15s %-15s", "Name", "Director", "Year", "Rating", "Borrower") +
                String.format("%-15s %-15s %-15s %-15s", "Titanic", "1997", "James Cameron", "7.7", "Monica") , outContent.toString());
    }

    @After
    public void cleanUpStreams() {
        System.setOut(original);
    }
}
