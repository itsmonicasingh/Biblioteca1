package com.twu.biblioteca;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.junit.Assert.assertEquals;

//Used for Input Output
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
    public void shouldDisplayListOfBooks() {
        View view = new View();
        Library library = new Library();
        view.displayListOfBooks(library);
        assertEquals("List of Books\nName            Author          Year \nRed Jhon        Martin          2004 \nSuccess         Ricky           1994 \n", outContent.toString());
    }

    @Test
    public void shouldDisplayInvalidOption() {
        View view = new View();

        view.displayInvalidOption();

        assertEquals("Select a valid option!\n",outContent.toString());
    }

    @After
    public void cleanUpStreams() {
        System.setOut(original);
    }
}
