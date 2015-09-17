package com.twu.biblioteca;

import org.junit.Test;

import java.util.ArrayList;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;


public class LoginTest {

    @Test
    public void shouldGiveTheUserObject() {
        View view = mock(View.class);
        ArrayList<User> users = new ArrayList<User>();
        User user1 = new User("Monica", "monicas@thoughtworks.com", "9448056963", "123-4567", "monica", true);
        User user2 = new User("Pooja", "pooja@thoughtworks.com", "9198704815", "765-4321", "pooja", false);
        users.add(user1);
        users.add(user2);
        Login login = new Login(users, view);

        when(view.getInput()).thenReturn("123-4567").thenReturn("monica");
        assertEquals(user1, login.authenticate());
    }
}