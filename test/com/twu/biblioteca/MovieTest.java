package com.twu.biblioteca;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class MovieTest {

    @Test
    public void moviesShouldReturnMovieDetails() {
        Movie movie = new Movie("Titanic", "1997", "James Cameron", "7.7");

        assertEquals(String.format("%-15s %-15s %-15s %-15s", "Titanic", "1997", "James Cameron", "7.7"), movie.toString());
    }
}