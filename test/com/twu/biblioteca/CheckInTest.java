package com.twu.biblioteca;

import org.junit.Before;
import org.junit.Test;

import static org.mockito.Mockito.*;

public class CheckInTest {

    private User user;
    Library mockedLibrary;
    View mockedView;
    CheckIn checkIn;

    @Before
    public void setUp() throws Exception {
        mockedLibrary = mock(Library.class);
        mockedView = mock(View.class);
        user = mock(User.class);
        checkIn = new CheckIn(mockedView, mockedLibrary, Messages.enterBookName, Messages.successfulBookCheckIn, Messages.unsuccessfulBookCheckIn, user);
        when(user.getName()).thenReturn("Monica");
    }

    @Test
    public void checkInShouldCallCheckInBook() {
        when(mockedView.getInput()).thenReturn("Alchemist");
        checkIn.execute();

        verify(mockedLibrary).checkInLibraryItem(user.getName(), "Alchemist");
    }

    @Test
    public void checkInShouldCallDisplaySuccessfulCheckout() {
        when(mockedLibrary.checkInLibraryItem(user.getName(), "Alchemist")).thenReturn(true);
        when(mockedView.getInput()).thenReturn("Alchemist");
        checkIn.execute();

        verify(mockedView).show(Messages.successfulBookCheckIn);
    }

    @Test
    public void checkInShouldCallDisplayUnSuccessfulCheckout() {
        when(mockedLibrary.checkInLibraryItem(user.getName(), "Alchemist")).thenReturn(false);
        when(mockedView.getInput()).thenReturn("Alchemist");
        checkIn.execute();

        verify(mockedView).show(Messages.unsuccessfulBookCheckIn);
    }
}