package com.twu.biblioteca;

import org.junit.Before;
import org.junit.Test;

import java.io.ByteArrayInputStream;
import java.util.Scanner;

import static org.junit.Assert.*;

public class UserInputTest {

    String userChoice = "1";
    final ByteArrayInputStream inContent = new ByteArrayInputStream(userChoice.getBytes());

    @Before
    public void setUp()
    {
        System.setIn(inContent);
    }
    @Test
    public void shouldReturnTheInputGivenByTheUser() {
        UserInput input = new UserInput(new Scanner(System.in));
        assertEquals("1", input.read());
    }
}