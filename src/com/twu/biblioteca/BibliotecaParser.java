package com.twu.biblioteca;

public class BibliotecaParser {

    public Operations parse(String userInput, View view, Library bookLibrary, Library moviesLibrary) {

        if (userInput.equals("0")) {
            return new Quit();
        } else if (userInput.equals("1")) {
            return new Display(view, bookLibrary.getLibraryItems(), Messages.listOfBooks, Messages.booksHeader);
        } else if (userInput.equals("2")) {
            return new Display(view, bookLibrary.getCheckedOutLibraryItems(), Messages.listOfCheckedOutBooks, Messages.booksHeader);
        } else if (userInput.equals("3")) {
            return new CheckOut(view, bookLibrary, Messages.enterBookName, Messages.successfulBookCheckout, Messages.unsuccessfulBookCheckOut);
        } else if (userInput.equals("4")) {
            return new CheckIn(view, bookLibrary, Messages.enterBookName, Messages.successfulBookCheckIn, Messages.unsuccessfulBookCheckIn);
        } else if (userInput.equals("5")) {
            return new Display(view, moviesLibrary.getLibraryItems(), Messages.listOfMovies, Messages.moviesHeader);
        } else if (userInput.equals("6")) {
            return new Display(view, moviesLibrary.getCheckedOutLibraryItems(), Messages.listOfCheckedOutMovies, Messages.moviesHeader);
        } else if (userInput.equals("7")) {
            return new CheckOut(view, moviesLibrary, Messages.enterMovieName, Messages.successfulMovieCheckout, Messages.unsuccessfulMovieCheckOut);
        } else if (userInput.equals("8")) {
            return new CheckIn(view, moviesLibrary, Messages.enterMovieName, Messages.successfulMovieCheckIn, Messages.unsuccessfulMovieCheckIn);
        }
        else {
            return new InvalidOption(view);
        }
    }
}
