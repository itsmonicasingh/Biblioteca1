package com.twu.biblioteca;

import org.junit.Test;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;

public class DisplayUserInformationTest {

    @Test
    public void ShouldCallShowUserInformation() {
        View view = mock(View.class);
        User user = mock(User.class);
        DisplayUserInformation displayUserInformation = new DisplayUserInformation(view, user);

        displayUserInformation.execute();

        verify(view).showUserInformation(user);
    }
}
