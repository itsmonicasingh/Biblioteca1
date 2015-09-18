package com.twu.biblioteca;

import java.util.ArrayList;
import java.util.HashMap;

//Starts the application
public class BibliotecaApp {

    public static void main(String[] args) {
        View view = new View();
        Book book1 = new Book("Dracula", "Bram Stoker", "2004");
        Book book2 = new Book("Alchemist", "Paulo Coelho", "2006");

        Movie movie1 = new Movie("Titanic", "1997", "James Cameron", "7.7");
        Movie movie2 = new Movie("InterStellar", "2014", "Christopher Nolan", "10");

        User user1 = new User("Monica", "monicas@thoughtworks.com", "9448056963", "123-4567", "monica", true);
        User user2 = new User("Pooja", "pooja@thoughtworks.com", "9198704815", "765-4321", "pooja", false);

        ArrayList<LibraryItem> books = new ArrayList<LibraryItem>();
        HashMap<LibraryItem, String> checkedBooks = new HashMap<LibraryItem, String>();

        ArrayList<LibraryItem> movies = new ArrayList<LibraryItem>();
        HashMap<LibraryItem, String> checkedMovies = new HashMap<LibraryItem, String>();

        ArrayList<User> users = new ArrayList<User>();

        books.add(book1);
        books.add(book2);
        movies.add(movie1);
        movies.add(movie2);
        users.add(user1);
        users.add(user2);
        Library booksLibrary = new Library(books, checkedBooks);
        Library moviesLibrary = new Library(movies, checkedMovies);
        Login login = new Login(users, view);
        BibliotecaParser parser = new BibliotecaParser(view, booksLibrary, moviesLibrary, login);
        BibliotecaController bibliotecaController = new BibliotecaController(view, parser);
        bibliotecaController.start();
    }
}