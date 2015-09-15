package com.twu.biblioteca;

//Book has title, author and year and checks if two books are same
public class Book implements LibraryItem {

    private String title;
    private String author;
    private String year;


    public Book(String title, String author, String year) {
        this.title = title;
        this.author = author;
        this.year = year;
    }

    public boolean hasTitle(String name) {
        return title.equals(name);
    }

    @Override
    public String toString() {
        return String.format("%-15s %-15s %-5s", title, author, year);
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
