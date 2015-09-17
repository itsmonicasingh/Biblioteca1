package com.twu.biblioteca;

import org.junit.Test;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;


public class DisplayCheckedOutListTest {

    @Test
    public void shouldCallDisplayCheckedOutItems() {
        View view = mock(View.class);
        Library library = mock(Library.class);
        DisplayCheckedOutList displayCheckedOutList = new DisplayCheckedOutList(view, library.getCheckedOutLibraryItems(), Messages.listOfCheckedOutMovies, Messages.checkedOutMoviesHeader);

        displayCheckedOutList.execute();

        verify(view).displayCheckedOutList(library.getCheckedOutLibraryItems(), Messages.listOfCheckedOutMovies, Messages.checkedOutMoviesHeader);
    }
}