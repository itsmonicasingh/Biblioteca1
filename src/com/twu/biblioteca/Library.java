package com.twu.biblioteca;

import java.util.ArrayList;

public class Library {
    private ArrayList<Book> books;

    public Library(ArrayList<Book> books) {
        this.books = books;
    }

    public ArrayList<Book> getBooks() {
        return books;
    }

    public boolean checkOutBook(String bookName) {
        for (Book book : books) {
            if (book.getName().equals(bookName)) {
                books.remove(book);
                return true;
            }
        }
        return false;
    }
}