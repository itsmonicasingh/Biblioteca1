package com.twu.biblioteca;

import org.junit.Rule;
import org.junit.Test;
import org.junit.contrib.java.lang.system.ExpectedSystemExit;

public class QuitTest {

    @Rule
    public final ExpectedSystemExit exit = ExpectedSystemExit.none();

    @Test
    public void shouldValidateQuit() {

        exit.expectSystemExitWithStatus(0);
        Quit quit = new Quit();
        quit.execute();

    }
}
