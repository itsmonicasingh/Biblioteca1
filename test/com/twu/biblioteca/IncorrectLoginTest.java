package com.twu.biblioteca;

import org.junit.Test;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;

public class IncorrectLoginTest {

    @Test
    public void shouldCallShowForIncorrectDisplay() {
        View view = mock(View.class);

        IncorrectLogin incorrectLogin = new IncorrectLogin(view);
        incorrectLogin.execute();

        verify(view).show(Messages.errorInLogin);
    }
}