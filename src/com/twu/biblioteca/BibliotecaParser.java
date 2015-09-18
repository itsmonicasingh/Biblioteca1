package com.twu.biblioteca;

public class BibliotecaParser {

    private View view;
    private Library booksLibrary;
    private Library moviesLibrary;
    private Login login;

    public BibliotecaParser(View view, Library booksLibrary, Library moviesLibrary, Login login) {
        this.view = view;
        this.booksLibrary = booksLibrary;
        this.moviesLibrary = moviesLibrary;
        this.login = login;
    }

    public Operations parse(String userInput, User user) {
        if (userInput.equals("0")) {
            return new Quit();
        } else if (userInput.equals("1")) {
            return new Display(view, booksLibrary.getLibraryItems(), Messages.listOfBooks, Messages.booksHeader);
        } else if (userInput.equals("2")) {
            return new CheckOut(view, booksLibrary, Messages.enterBookName, Messages.successfulBookCheckout, Messages.unsuccessfulBookCheckOut, user);
        } else if (userInput.equals("3")) {
            return new CheckIn(view, booksLibrary, Messages.enterBookName, Messages.successfulBookCheckIn, Messages.unsuccessfulBookCheckIn, user);
        } else if (userInput.equals("4")) {
            return new Display(view, moviesLibrary.getLibraryItems(), Messages.listOfMovies, Messages.moviesHeader);
        } else if (userInput.equals("5")) {
            return new CheckOut(view, moviesLibrary, Messages.enterMovieName, Messages.successfulMovieCheckout, Messages.unsuccessfulMovieCheckOut, user);
        } else if (userInput.equals("6")) {
            return new CheckIn(view, moviesLibrary, Messages.enterMovieName, Messages.successfulMovieCheckIn, Messages.unsuccessfulMovieCheckIn, user);
        } else if (userInput.equals("7")) {
            return new DisplayUserInformation(view, user);
        } else if (userInput.equals("8")) {
            if (user.isLibrarian())
                return new DisplayCheckedOutList(view, booksLibrary.getCheckedOutLibraryItems(), Messages.listOfCheckedOutBooks, Messages.checkedOutBooksHeader);
            return new NullObject();
        } else if (userInput.equals("9")) {
            if (user.isLibrarian())
                return new DisplayCheckedOutList(view, moviesLibrary.getCheckedOutLibraryItems(), Messages.listOfCheckedOutMovies, Messages.checkedOutMoviesHeader);
            return new InvalidOption(view);
        } else if (userInput.equals("10")) {
            if (user.isLibrarian())
                return new DisplayListOfUsers(view, login.getUsers(), Messages.listOfUsers, Messages.userHeader);
            return new InvalidOption(view);
        } else if (userInput.equals("11")) {
            if (user.isLibrarian())
                return new NullObject();
            return new InvalidOption(view);
        } else {
            return new InvalidOption(view);
        }
    }

    public Operations parse(User user) {
        if (user == null) {
            return new IncorrectLogin(view);
        }
        if (user.isLibrarian()) {
            return new UserController(view, user, this, Messages.librarianMenu);
        } else {
            return new UserController(view, user, this, Messages.userMenu);
        }
    }

    public Operations parse(String input) {
        if (input.equals("0")) {
            return new Quit();
        } else if (input.equals("1")) {
            return new LoginController(this, login);
        } else {
            return new InvalidOption(view);
        }
    }
}
