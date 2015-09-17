package com.twu.biblioteca;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class BibliotecaParserTest {

    BibliotecaParser bibliotecaParser;
    View view;
    Library bookLibrary;
    Library moviesLibrary;
    User user;
    LoginController loginController;
    private Login login;


    @Before
    public void setUp() {
        view = mock(View.class);
        bookLibrary = mock(Library.class);
        moviesLibrary = mock(Library.class);
        user = mock(User.class);
        loginController = mock(LoginController.class);
        login = mock(Login.class);
        bibliotecaParser = new BibliotecaParser(view, bookLibrary, moviesLibrary, login);
    }

    @Test
    public void shouldGiveQuitObject() {
        assertEquals(Quit.class, bibliotecaParser.parse("0",  user).getClass());
    }

    @Test
    public void shouldReturnDisplayBooksObject() {
        assertEquals(Display.class, bibliotecaParser.parse("1",  user).getClass());
    }

    @Test
    public void shouldGiveCheckoutObject() {
        assertEquals(Display.class, bibliotecaParser.parse("2",  user).getClass());
    }

    @Test
    public void shouldGiveCheckInObject() {
        assertEquals(CheckOut.class, bibliotecaParser.parse("3", user).getClass());
    }

    @Test
    public void shouldReturnDisplayMoviesObject() {
        assertEquals(CheckIn.class, bibliotecaParser.parse("4",  user).getClass());
    }

    @Test
    public void shouldGiveCheckoutObjectOn5AsInput() {
        assertEquals(Display.class, bibliotecaParser.parse("5",  user).getClass());
    }

    @Test
    public void shouldGiveCheckInObjectOn6AsInput() {
        assertEquals(Display.class, bibliotecaParser.parse("6",  user).getClass());
    }

    @Test
    public void shouldGiveDisplayUserInformationObjectOn7AsInput() {
        assertEquals(DisplayUserInformation.class, bibliotecaParser.parse("7", user).getClass());
    }

    @Test
    public void shouldGiveDisplayCheckOutListObjectOn8AsInput() {
        when(user.isLibrarian()).thenReturn(true);

        assertEquals(DisplayCheckedOutList.class, bibliotecaParser.parse("8", user).getClass());
    }

    @Test
    public void shouldGiveInvalidOptionObjectOn9AsInputWhenUserIsNotLibrarian() {
        when(user.isLibrarian()).thenReturn(false);

        assertEquals(InvalidOption.class, bibliotecaParser.parse("9", user).getClass());
    }

    @Test
    public void shouldGiveDisplayUserListObjectOn10AsInputWhenUserIsLibrarian() {
        when(user.isLibrarian()).thenReturn(true);

        assertEquals(DisplayListOfUsers.class, bibliotecaParser.parse("10", user).getClass());
    }

    @Test
    public void shouldGiveLoginObjectOn1AsOptionInLoginMenu() {
        assertEquals(LoginController.class, bibliotecaParser.parse("1").getClass());
    }

    @Test
    public void shouldGiveNullObjectOnLogOut() {
        when(user.isLibrarian()).thenReturn(false);

        assertEquals(NullObject.class, bibliotecaParser.parse("8", user).getClass());
    }

    @Test
    public void shouldGiveInvalidOptionObject() {
        assertEquals(InvalidOption.class, bibliotecaParser.parse("90", user).getClass());
    }

    @Test
    public void shouldGiveUserControllerWhenUserExists() {
        assertEquals(UserController.class, bibliotecaParser.parse(user).getClass());
    }
}

