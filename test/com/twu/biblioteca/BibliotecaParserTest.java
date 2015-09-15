package com.twu.biblioteca;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;

import static org.junit.Assert.assertEquals;

public class BibliotecaParserTest {

    BibliotecaParser bibliotecaParser;
    View view;
    Library bookLibrary;
    Library moviesLibrary;


    @Before
    public void setUp() {
        bibliotecaParser = new BibliotecaParser();
        view = Mockito.mock(View.class);
        bookLibrary = Mockito.mock(Library.class);
        moviesLibrary = Mockito.mock(Library.class);
    }

    @Test
    public void shouldGiveQuitObject() {
        assertEquals(Quit.class, bibliotecaParser.parse("0",  view, bookLibrary, moviesLibrary).getClass());
    }

    @Test
    public void shouldReturnDisplayBooksObject() {
        assertEquals(Display.class, bibliotecaParser.parse("1",  view, bookLibrary, moviesLibrary).getClass());
    }

    @Test
    public void shouldGiveCheckoutObject() {
        assertEquals(Display.class, bibliotecaParser.parse("2",  view, bookLibrary, moviesLibrary).getClass());
    }

    @Test
    public void shouldGiveCheckInObject() {
        assertEquals(CheckOut.class, bibliotecaParser.parse("3", view, bookLibrary, moviesLibrary).getClass());
    }

    @Test
    public void shouldReturnDisplayMoviesObject() {
        assertEquals(CheckIn.class, bibliotecaParser.parse("4",  view, bookLibrary, moviesLibrary).getClass());
    }

    @Test
    public void shouldGiveCheckoutObjectOn5AsInput() {
        assertEquals(Display.class, bibliotecaParser.parse("5",  view, bookLibrary, moviesLibrary).getClass());
    }

    @Test
    public void shouldGiveCheckInObjectOn6AsInput() {
        assertEquals(Display.class, bibliotecaParser.parse("6",  view, bookLibrary, moviesLibrary).getClass());
    }
}

