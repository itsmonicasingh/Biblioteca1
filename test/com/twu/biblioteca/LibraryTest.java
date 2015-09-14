package com.twu.biblioteca;

import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;

import static org.junit.Assert.assertEquals;

public class LibraryTest {
    ArrayList<Book> books;
    ArrayList<Book> books1;
    ArrayList<Book> checkedOutBooks;
    Book book1;
    Book book2;
    Book book3;
    Book book4;
    Library library;

    @Before
    public void setUp() throws Exception {
        book1 = new Book("Dracula","Bram Stoker ","1994");
        book2 = new Book("Alchemist", "Paulo Coelho", "2006");
        book3 = new Book("Dracula","Bram Stoker ","1994");
        book4 = new Book("Alchemist", "Paulo Coelho", "2006");
        books = new ArrayList<Book>();
        books1 = new ArrayList<Book>();
        checkedOutBooks = new ArrayList<Book>();

        books.add(book1);
        books.add(book2);
        books1.add(book3);
        books1.add(book4);
        library = new Library(books, checkedOutBooks);

    }

    @Test
    public void shouldGiveListOfBooks() {
        assertEquals(books1, library.getBooks());
    }

    @Test
    public void shouldRemoveBookFromLibrary() {
        library.checkOutBook("Alchemist");
        books1.remove(book4);
        assertEquals(books1, library.getBooks());
    }

    @Test
    public void shouldGiveTrueOnSuccessfulCheckout() {
        assertEquals(true, library.checkOutBook("Alchemist"));
    }

    @Test
    public void shouldGiveFalseOnUnSuccessfulCheckout() {
        assertEquals(false, library.checkOutBook("heheh"));
    }

    @Test
    public void shouldCheckInBookToLibrary() {
        library.checkOutBook("Alchemist");
        assertEquals(true, library.checkInBook("Alchemist"));
    }

    @Test
    public void shouldNotCheckInBookToLibrary() {
        assertEquals(false, library.checkInBook("This book was never in the library"));
    }
}



