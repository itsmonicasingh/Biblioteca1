package com.twu.biblioteca;

import java.util.ArrayList;

public class BibliotecaApp {

    public static void main(String[] args) {
        View view = new View();
        Book book1 = new Book("Dracula", "Bram Stoker", "2004");
        Book book2 = new Book("Alchemist", "Paulo Coelho", "2006");

        Movie movie1 = new Movie("Titanic", "1997", "James Cameron", "7.7");
        Movie movie2 = new Movie("InterStellar", "2014", "Christopher Nolan", "10");

        ArrayList<LibraryItem> books = new ArrayList<LibraryItem>();
        ArrayList<LibraryItem> checkOutBooks = new ArrayList<LibraryItem>();

        ArrayList<LibraryItem> movies = new ArrayList<LibraryItem>();
        ArrayList<LibraryItem> checkedOutMovies = new ArrayList<LibraryItem>();

        books.add(book1);
        books.add(book2);
        movies.add(movie1);
        movies.add(movie2);

        Library booksLibrary = new Library(books, checkOutBooks);
        Library moviesLibrary = new Library(movies, checkedOutMovies);
        BibliotecaController bibliotecaController = new BibliotecaController(view, booksLibrary, moviesLibrary);
        bibliotecaController.start();
    }
}
