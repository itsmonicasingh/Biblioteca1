package com.twu.biblioteca;

import org.junit.Before;
import org.junit.Test;
import static org.mockito.Mockito.*;

public class CheckOutTest {

    User user;
    Library mockedLibrary;
    View mockedView;
    CheckOut checkOut;

    @Before
    public void setUp() throws Exception {
        mockedLibrary = mock(Library.class);
        mockedView = mock(View.class);
        user = mock(User.class);
        checkOut = new CheckOut(mockedView, mockedLibrary, Messages.enterBookName, Messages.successfulBookCheckout, Messages.unsuccessfulBookCheckOut, user);
        when(user.getName()).thenReturn("Monica");
    }

    @Test
    public void checkOutShouldCallCheckOutBook() {
        when(mockedView.getInput()).thenReturn("Alchemist");
        checkOut.execute();

        verify(mockedLibrary).checkOutLibraryItem(user.getName(), "Alchemist");
    }

    @Test
    public void checkOutShouldCallDisplaySuccessfulCheckout() {
        when(mockedLibrary.checkOutLibraryItem(user.getName(), "Alchemist")).thenReturn(true);
        when(mockedView.getInput()).thenReturn("Alchemist");
        checkOut.execute();

        verify(mockedView).show(Messages.successfulBookCheckout);
    }

    @Test
    public void checkOutShouldCallDisplayUnSuccessfulCheckout() {
        when(mockedLibrary.checkOutLibraryItem(user.getName(), "Nobook")).thenReturn(false);
        when(mockedView.getInput()).thenReturn("Nobook");
        checkOut.execute();

        verify(mockedView).show(Messages.unsuccessfulBookCheckOut);
    }
}
