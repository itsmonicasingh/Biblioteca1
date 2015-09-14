package com.twu.biblioteca;

import org.junit.Test;

import static org.mockito.Mockito.*;

public class CheckInTest {

    @Test
    public void checkInShouldCallCheckInBook() {
        Library mockedLibrary = mock(Library.class);
        View mockedView = mock(View.class);

        CheckIn checkIn = new CheckIn(mockedView, mockedLibrary);

        when(mockedView.getInput()).thenReturn("Alchemist");
        checkIn.execute();

        verify(mockedLibrary).checkInBook("Alchemist");
    }

    @Test
    public void checkInShouldCallDisplaySuccessfulCheckout() {
        Library mockedLibrary = mock(Library.class);
        View mockedView = mock(View.class);

        CheckIn checkIn = new CheckIn(mockedView, mockedLibrary);

        when(mockedLibrary.checkInBook("Alchemist")).thenReturn(true);
        when(mockedView.getInput()).thenReturn("Alchemist");
        checkIn.execute();

        verify(mockedView).displaySuccessfulCheckIn();
    }

    @Test
    public void checkInShouldCallDisplayUnSuccessfulCheckout() {
        Library mockedLibrary = mock(Library.class);
        View mockedView = mock(View.class);

        CheckIn checkIn = new CheckIn(mockedView, mockedLibrary);

        when(mockedLibrary.checkInBook("Alchemist")).thenReturn(false);
        when(mockedView.getInput()).thenReturn("Alchemist");
        checkIn.execute();

        verify(mockedView).displayUnSuccessfulCheckIn();
    }
}