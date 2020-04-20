package com.twu.biblioteca;

import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;

import static org.hamcrest.core.IsEqual.equalTo;
import static org.junit.Assert.*;

public class BibliotecaAppTest {
    private BibliotecaApp Main;
    private BookList bookList;

    @Before
    public void init(){
        Main = new BibliotecaApp();
        bookList = new BookList();
    }

//    @Test
//    public void testWelcomeMessage(){
//        assertThat(Main.welcome(), equalTo("Welcome to Biblioteca. Your one-stop-shop for great book titles in Bangalore!"));
//    }

//    @Test
//    public void testBorrowABook(){
//        assertThat(bookList.printDetailList(), equalTo(9);
//        bookList.borrowBook(bookList[3]);
//        assertThat(bookList.printDetailList(), equalTo(8);
//    }
//
//    @Test
//    public void testReturnABook(){
//        assertThat(bookList.printDetailList(), equalTo(9);
//        bookList.borrowBook(bookList[6]);
//        assertThat(bookList.printDetailList(), equalTo(10);
//    }

}