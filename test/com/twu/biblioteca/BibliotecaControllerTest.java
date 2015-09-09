package com.twu.biblioteca;

import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.contrib.java.lang.system.ExpectedSystemExit;

import static org.mockito.Mockito.*;

public class BibliotecaControllerTest {
    View mockedView;
    Library mockedLibrary;
    BibliotecaController bibliotecaController;

    @Rule
    public final ExpectedSystemExit exit = ExpectedSystemExit.none();

    @Before
    public void setUp() throws Exception {
        mockedView = mock(View.class);
        mockedLibrary = mock(Library.class);
        bibliotecaController = new BibliotecaController(mockedView, mockedLibrary);

    }

    @Test
    public void menuShouldCallDisplayListOfBooks() {
        when(mockedView.getInput()).thenReturn("1").thenReturn("0");
        exit.expectSystemExitWithStatus(0);
        bibliotecaController.start();

        verify(mockedView).displayMenu();
    }

    @Test
    public void menuShouldDisplayInvalidOption() {
        when(mockedView.getInput()).thenReturn("3").thenReturn("0");
        exit.expectSystemExitWithStatus(0);

        bibliotecaController.start();

        verify(mockedView).displayInvalidOption();
    }
}


   