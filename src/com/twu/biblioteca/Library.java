package com.twu.biblioteca;

import java.util.ArrayList;

public class Library {
    private ArrayList<Book> books;
    private ArrayList<Book> checkedOutBooks;

    public Library(ArrayList<Book> books, ArrayList<Book> checkedOutBooks) {
        this.books = books;
        this.checkedOutBooks = checkedOutBooks;
    }

    public ArrayList<Book> getBooks() {
        return books;
    }

    public boolean checkOutBook(String title) {
        for (Book book : books) {
            if (book.getTitle().equals(title)) {
                books.remove(book);
                checkedOutBooks.add(book);
                return true;
            }
        }
        return false;
    }

    public boolean checkInBook(String title) {
        for (Book book : checkedOutBooks) {
            if (book.getTitle().equals(title)) {
                checkedOutBooks.remove(book);
                books.add(book);
                return true;
            }
        }
        return false;
    }
}