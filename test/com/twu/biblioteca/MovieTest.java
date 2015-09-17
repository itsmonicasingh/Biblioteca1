package com.twu.biblioteca;

import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class MovieTest {

    @Test
    public void moviesShouldReturnMovieDetails() {
        Movie movie = new Movie("Titanic", "James Cameron", "1997", "7.7");

        assertEquals(String.format("%-15s %-15s %-15s %-15s", "Titanic", "1997","James Cameron", "7.7"), movie.toString());
    }

    @Test
    public void moviesTitleShouldBeTrueForSameTitle() {
        Movie movie = new Movie("Titanic", "1997","James Cameron", "7.7");

        assertTrue(movie.hasTitle("Titanic"));
    }
}