package com.twu.biblioteca;

import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.contrib.java.lang.system.ExpectedSystemExit;

import static org.mockito.Mockito.*;

public class BibliotecaControllerTest {
    View mockedView;
    Library mockedBookLibrary;
    Library mockedMovieLibrary;
    BibliotecaController bibliotecaController;

    @Rule
    public ExpectedSystemExit exit = ExpectedSystemExit.none();

    @Before
    public void setUp() throws Exception {
        mockedView = mock(View.class);
        mockedMovieLibrary = mock(Library.class);
        mockedBookLibrary = mock(Library.class);
        bibliotecaController = new BibliotecaController(mockedView, mockedBookLibrary, mockedMovieLibrary);

    }

    @Test
    public void menuShouldCallDisplayListOfBooks() {
        when(mockedView.getInput()).thenReturn("1").thenReturn("0");
        exit.expectSystemExitWithStatus(0);
        bibliotecaController.start();

        verify(mockedView).show(Messages.menu);
    }

    @Test
    public void menuShouldDisplayInvalidOption() {
        when(mockedView.getInput()).thenReturn("3").thenReturn("0");
        exit.expectSystemExitWithStatus(0);

        bibliotecaController.start();

        verify(mockedView).show(Messages.invalidOption);
    }
}


