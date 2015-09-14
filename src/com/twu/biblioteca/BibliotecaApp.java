package com.twu.biblioteca;

import java.util.ArrayList;

public class BibliotecaApp {

    public static void main(String[] args) {
        View view = new View();
        Book book1 = new Book("Dracula", "Bram Stoker", "2004");
        Book book2 = new Book("Alchemist", "Paulo Coelho", "2006");
        ArrayList<Book> books = new ArrayList<Book>();
        ArrayList<Book> checkOutBooks = new ArrayList<Book>();
        books.add(book1);
        books.add(book2);
        Library library = new Library(books, checkOutBooks);
        BibliotecaController bibliotecaController = new BibliotecaController(view, library);;
        bibliotecaController.start();
    }
}
