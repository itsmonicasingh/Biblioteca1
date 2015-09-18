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

        assertEquals("List of Books\n" + String.format("%-20s %-20s %-20s\n", "Title", "Author", "Year Of Publication") +
                String.format("%-20s %-20s %-20s\n", "Alchemist", "Paulo Coelho", 2006) +
                String.format("%-20s %-20s %-20s\n", "Dracula", "Bram Stoker", 1998), outContent.toString());
    }

    @Test
    public void shouldDisplayInvalidOption() {
        View view = new View();

        view.show(Messages.invalidOption);

        assertEquals("Select a valid option!\n", outContent.toString());
    }

    @Test
    public void shouldDisplayMenuOptions() {
        View view = new View();

        view.show(Messages.librarianMenu);

        assertEquals("\n~~~~~~~~~~~~Menu~~~~~~~~~~~~\n" +
                "==============================\n" +
                "[0] Quit\n" +
                "[1] List Of Available Books\n" +
                "[2] Checkout Book\n" +
                "[3] CheckIn Book\n" +
                "[4] List Of Available Movies\n" +
                "[5] CheckOut Movie\n" +
                "[6] CheckIn Movie\n" +
                "[7] My Profile\n" +
                "[8] List Of CheckedOut Books\n" +
                "[9] List Of CheckedOut Movies\n" +
                "[10] List Of Users\n" +
                "[11] LogOut\n" +
                "==============================\n" +
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
        User user = new User("Monica", "monicas@thoughtworks.com", "9448056963", "123-4567", "monica", true);

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
                String.format("%-20s %-20s %-20s %-20s %-20s\n", "Name", "Director", "year", "ratings", "Borrower") +
                String.format("%-20s %-20s %-20s %-20s %-20s", "Titanic", "James Cameron", "1997", "7.7", "Monica"), outContent.toString());
    }

    @Test
    public void shouldDisplayListOfUsers() {
        View view = new View();
        ArrayList<User> users = new ArrayList<User>();
        User user1 = new User("Monica", "monicas@thoughtworks.com", "9448056963", "123-4567", "monica", true);
        User user2 = new User("Pooja", "pooja@thoughtworks.com", "9198704815", "765-4321", "pooja", false);

        users.add(user1);
        users.add(user2);
        view.displayListOfUsers(users, Messages.listOfUsers, Messages.userHeader);

        assertEquals("List of Users\n" +
                String.format("%-20s %-20s %-20s\n", "Name", "Email Address", "PhoneNo") + "\n" +
                String.format("%-1s %-1s %-1s\n", "Monica", "monicas@thoughtworks.com", "9448056963") +
                String.format("%-1s %-1s %-1s\n", "Pooja", "pooja@thoughtworks.com", "9198704815"), outContent.toString());
    }

    @After
    public void cleanUpStreams() {
        System.setOut(original);
    }
}