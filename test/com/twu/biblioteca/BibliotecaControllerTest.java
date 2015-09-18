package com.twu.biblioteca;

import org.junit.Rule;
import org.junit.Test;
import org.junit.contrib.java.lang.system.ExpectedSystemExit;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class BibliotecaControllerTest {

    @Rule
    public ExpectedSystemExit exit = ExpectedSystemExit.none();

    @Test
    public void menuShouldReturnExit() {
        View mockedView = mock(View.class);
        BibliotecaParser mockedParser = mock(BibliotecaParser.class);
        BibliotecaController bibliotecaController = new BibliotecaController(mockedView, mockedParser);

        when(mockedView.getInput()).thenReturn("0");
        when(mockedParser.parse("0")).thenReturn(new Quit());

        exit.expectSystemExitWithStatus(0);

        bibliotecaController.start();
    }
}