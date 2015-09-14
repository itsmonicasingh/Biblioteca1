package com.twu.biblioteca;

public class Book {

    private String title;
    private String author;
    private String year;


    public Book(String title, String author, String year) {
        this.title = title;
        this.author = author;
        this.year = year;
    }

    public Boolean hasTitle(String name) {
        if (title.equals(name))
            return true;
        return false;
    }

    @Override
    public String toString() {
        return String.format("%-15s %-15s %-5s",title,author,year);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Book book = (Book) o;

        return title.equals(book.title);
    }

    @Override
    public int hashCode() {
        return title.hashCode();
    }
}
