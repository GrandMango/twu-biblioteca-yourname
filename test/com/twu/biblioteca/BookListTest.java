package com.twu.biblioteca;

import org.junit.Before;
import org.junit.Test;

import static org.hamcrest.core.IsEqual.equalTo;
import static org.junit.Assert.*;

public class BookListTest {
    private BookList bookList;

    @Before
    public void init(){
        this.bookList = new BookList();
    }

    @Test
    public void printDetailList(){
        assertThat(bookList.printDetailList(), equalTo(9));
    }

    @Test
    public void printOverviewList(){
        assertThat(bookList.printOverviewList(), equalTo(9));
    }

    @Test
    public void isBookAvailabelById(){
        assertThat(bookList.borrowBookById("#003"), equalTo(true));
        assertThat(bookList.borrowBookById("#006"), equalTo(false));
    }

    @Test
    public void isBookAvailabelByName(){
        assertThat(bookList.borrowBookByName("The Goblet of Fire"), equalTo(true));
        assertThat(bookList.borrowBookByName("The Half-Blood Prince"), equalTo(false));
    }

    @Test
    public void borrowBook(){
        assertThat(bookList.findBookByName("The Goblet of Fire").getIsAvailable(), equalTo("Available"));
        bookList.borrowBook(bookList.findBookById("#004"));
        assertThat(bookList.findBookByName("The Goblet of Fire").getIsAvailable(), equalTo("Unavailable"));
    }

    @Test
    public void returnBook(){
        assertThat(bookList.findBookById("#006").getIsAvailable(), equalTo("Unavailable"));
        bookList.returnBook(bookList.findBookById("#006"));
        assertThat(bookList.findBookById("#006").getIsAvailable(), equalTo("Available"));
    }

    @Test
    public void testBorrowABookByid(){
        assertThat(bookList.printDetailList(), equalTo(9));
        assertThat(bookList.findBookById("#004").getIsAvailable(), equalTo("Available"));
        bookList.borrowBookById("#004");
        assertThat(bookList.findBookById("#004").getIsAvailable(), equalTo("Unavailable"));
        assertThat(bookList.printDetailList(), equalTo(8));
    }

    @Test
    public void testBorrowABookByName(){
        assertThat(bookList.printDetailList(), equalTo(9));
        assertThat(bookList.findBookByName("The Order of the Phoenix").getIsAvailable(),
                equalTo("Available"));
        bookList.borrowBookByName("The Order of the Phoenix");
        assertThat(bookList.findBookByName("The Order of the Phoenix").getIsAvailable(),
                equalTo("Unavailable"));
        assertThat(bookList.printDetailList(), equalTo(8));
    }

    @Test
    public void testReturnABook(){
        assertThat(bookList.printDetailList(), equalTo(9));
        assertThat(bookList.findBookById("#006").getIsAvailable(), equalTo("Unavailable"));
        bookList.returnBookById("#006");
        assertThat(bookList.findBookById("#006").getIsAvailable(), equalTo("Available"));
        assertThat(bookList.printDetailList(), equalTo(10));
    }
}