package com.twu.biblioteca;

import org.junit.Test;
import static org.mockito.Mockito.*;

public class CheckOutTest {

    @Test
    public void checkOutShouldCallCheckOutBook() {
        Library mockedLibrary = mock(Library.class);
        View mockedView = mock(View.class);

        CheckOut checkOut = new CheckOut(mockedView, mockedLibrary);

        when(mockedView.getInput()).thenReturn("Alchemist");
        checkOut.execute();
        verify(mockedLibrary).checkOutLibraryItem("Alchemist");
    }

    @Test
    public void checkOutShouldCallDisplaySuccessfulCheckout() {
        Library mockedLibrary = mock(Library.class);
        View mockedView = mock(View.class);

        CheckOut checkOut = new CheckOut(mockedView, mockedLibrary);

        when(mockedLibrary.checkOutLibraryItem("Alchemist")).thenReturn(true);
        when(mockedView.getInput()).thenReturn("Alchemist");
        checkOut.execute();

        verify(mockedView).show(Messages.successfulBookCheckout);
    }

    public void checkOutShouldCallDisplayUnSuccessfulCheckout() {
        Library mockedLibrary = mock(Library.class);
        View mockedView = mock(View.class);

        CheckOut checkOut = new CheckOut(mockedView, mockedLibrary);

        when(mockedLibrary.checkOutLibraryItem("SuccessFactor")).thenReturn(false);
        when(mockedView.getInput()).thenReturn("SuccessFactor");
        checkOut.execute();

        verify(mockedView).show(Messages.unsuccessfulBookCheckOut);
    }
}
