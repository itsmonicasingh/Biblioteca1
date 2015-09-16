package com.twu.biblioteca;

import org.junit.Before;
import org.junit.Test;

import java.util.HashMap;

import java.util.ArrayList;

import static org.junit.Assert.assertEquals;

public class LibraryTest {
    ArrayList<LibraryItem> books;
    ArrayList<LibraryItem> books1;
    Book book1;
    Book book2;
    Book book3;
    Book book4;
    Library bookLibrary;

    ArrayList<LibraryItem> movies;
    ArrayList<LibraryItem> movies1;
    Movie movie1;
    Movie movie2;
    Movie movie3;
    Movie movie4;
    Library movieLibrary;
    private HashMap<LibraryItem, String> checkedOutBooks;
    private HashMap<LibraryItem, String> checkedOutMovies;
    private String user;

    @Before
    public void setUp() throws Exception {
        book1 = new Book("Dracula","Bram Stoker ","1994");
        book2 = new Book("Alchemist", "Paulo Coelho", "2006");
        book3 = new Book("Dracula","Bram Stoker ","1994");
        book4 = new Book("Alchemist", "Paulo Coelho", "2006");
        books = new ArrayList<LibraryItem>();
        books1 = new ArrayList<LibraryItem>();

        movie1 = new Movie("Titanic", "1997", "James Cameron", "7.7");
        movie2 = new Movie("InterStellar", "2014", "Christopher Nolan", "10");
        movie3 = new Movie("Titanic", "1997", "James Cameron", "7.7");
        movie4 = new Movie("InterStellar", "2014", "Christopher Nolan", "10");
        movies = new ArrayList<LibraryItem>();
        movies1 = new ArrayList<LibraryItem>();
        checkedOutBooks = new HashMap<LibraryItem, String>();
        checkedOutMovies = new HashMap<LibraryItem, String>();

        user = "Monica";

        books.add(book1);
        books.add(book2);
        books1.add(book3);
        books1.add(book4);

        movies.add(movie1);
        movies.add(movie2);
        movies1.add(movie3);
        movies1.add(movie4);

        bookLibrary = new Library(books, checkedOutBooks);
        movieLibrary = new Library(movies, checkedOutMovies);
    }

    @Test
    public void shouldGiveListOfMovies() {
        assertEquals(movies, movieLibrary.getLibraryItems());
    }

    @Test
    public void shouldGiveListOfBooks() {
        assertEquals(books1, bookLibrary.getLibraryItems());
    }

    @Test
    public void shouldRemoveBookFromLibrary() {
        bookLibrary.checkOutLibraryItem(user, "Alchemist");
        books1.remove(book4);
        assertEquals(books1, bookLibrary.getLibraryItems());
    }

    @Test
    public void shouldGiveTrueOnSuccessfulCheckout() {
        assertEquals(true, bookLibrary.checkOutLibraryItem(user, "Alchemist"));
    }

    @Test
    public void shouldGiveFalseOnUnSuccessfulCheckout() {
        assertEquals(false, bookLibrary.checkOutLibraryItem(user, "heheh"));
    }

    @Test
    public void shouldCheckInBookToLibrary() {
        bookLibrary.checkOutLibraryItem(user, "Alchemist");
        assertEquals(true, bookLibrary.checkInLibraryItem(user, "Alchemist"));
    }

    @Test
    public void shouldNotCheckInBookToLibrary() {
        assertEquals(false, bookLibrary.checkInLibraryItem(user, "This book was never in the library"));
    }
}



