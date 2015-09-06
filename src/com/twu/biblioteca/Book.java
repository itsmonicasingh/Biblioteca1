package com.twu.biblioteca;

public class Book {

    private String name;
    private final String author;
    private final String year;


    public Book(String name, String author, String year) {
        this.name = name;
        this.author = author;
        this.year = year;
    }

    public String getName() {
        return name;
    }

    public String getYear() {
        return year;
    }

    public String getAuthor() {
        return author;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Book book = (Book) o;

        return name.equals(book.name);
    }

    @Override
    public int hashCode() {
        return name.hashCode();
    }
}
