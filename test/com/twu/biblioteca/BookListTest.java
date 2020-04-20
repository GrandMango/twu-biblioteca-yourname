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

//    @Test
//    public void borrowBook(){
//        assertThat(bookList.isBookAvailabelByName("The Goblet of Fire"), equalTo(true));
//        bookList.borrowBook(bookList[3]);
//        assertThat(bookList.isBookAvailabelByName("The Goblet of Fire"), equalTo(false));
//    }

}