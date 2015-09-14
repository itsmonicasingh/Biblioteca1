package com.twu.biblioteca;

import java.util.ArrayList;

public class Library {
    private ArrayList<Book> books;
    private ArrayList<Book> checkedoutBooks;

    public Library(ArrayList<Book> books, ArrayList<Book> checkedOutBooks) {
        this.books = books;
        this.checkedoutBooks = checkedOutBooks;
    }

    public ArrayList<Book> getBooks() {
        return books;
    }

    public boolean checkOutBook(String title) {
        for (Book book : books) {
            if (book.getName().equals(title)) {
                books.remove(book);
                checkedoutBooks.add(book);
                return true;
            }
        }
        return false;
    }

    public boolean checkInBook(String title) {
        for (Book book : checkedoutBooks) {
            if (book.getName().equals(title)) {
                checkedoutBooks.remove(book);
                books.add(book);
                return true;
            }
        }
        return false;
    }
}