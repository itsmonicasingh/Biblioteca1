package com.twu.biblioteca;

import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;

public class BookTest {

    @Test
    public void shouldGiveBookName() {
        Book book = new Book("Red Jhon","Martin ","1994");
        assertEquals("Red Jhon        Martin          1994 ", book.toString());
    }

    @Test
    public void shouldBeEqualWhenComparingABookToItself() {
        Book Book = new Book("Dracula","Bram Stoker ","1994");

        assertEquals(Book, Book);
    }

    @Test
    public void shouldNotBeEqualWhenComparingABookToNull() {
        assertNotEquals(new Book("Dracula","Bram Stoker ","1994"), null);
    }

    @Test
    public void shouldNotBeEqualWhenComparingABookToNonBookEntity() {
        assertNotEquals(new Book("Dracula","Bram Stoker ","1994"), "I am Not a Book");
    }

    @Test
    public void shouldHaveSameHashCodeComparingABookToItself() {
        Book Book = new Book("Dracula","Bram Stoker ","1994");

        assertEquals(Book.hashCode(), Book.hashCode());
    }

    @Test
    public void shouldHaveSameHashCodeComparingABookToAnotherBookWithSameCoordinates() {
        assertEquals(new Book("Dracula","Bram Stoker ","1994"), new Book("Dracula","Bram Stoker ","1994"));
    }

    @Test
    public void shouldReturnTrueWhenTitlesOfTwoBooksAreSame() {
        Book book = new Book("Dracula", "Bram Stoker ","1994");
        assertEquals(true, book.hasTitle("Dracula"));
    }
}
