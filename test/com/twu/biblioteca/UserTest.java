package com.twu.biblioteca;

import org.junit.Test;

import static org.junit.Assert.assertEquals;


public class UserTest {

    @Test
    public void credentialsShouldMatch() {
        User user = new User("Monica", "monicas@thoughtworks.com", "9448056963", "123-4567", "itsme");

        assertEquals(true, user.match("123-4567", "itsme"));
    }
}
