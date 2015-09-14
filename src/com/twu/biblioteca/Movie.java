package com.twu.biblioteca;

//Movie has name, year, director and ratings
public class Movie {
    private String name;
    private String year;
    private String director;
    private String ratings;

    public Movie(String name, String year, String director, String ratings) {
        this.name = name;
        this.year = year;
        this.director = director;
        this.ratings = ratings;
    }

    @Override
    public String toString() {
        return String.format("%-15s %-15s %-15s %-15s", name, year, director, ratings);
    }
}