package com.twu.biblioteca;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;


public class UserTest {
    User user;

    @Before
    public void setUp() throws Exception {
        user = new User("Monica", "monicas@thoughtworks.com", "9448056963", "123-4567", "monica", true);
    }

    @Test
    public void credentialsShouldMatch() {
        assertEquals(true, user.match("123-4567", "monica"));
    }

    @Test
    public void isLibrarianShouldGiveTrue() {
        assertEquals(true, user.isLibrarian());
    }
}
