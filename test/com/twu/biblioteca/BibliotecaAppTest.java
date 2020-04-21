package com.twu.biblioteca;

import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;

import static org.hamcrest.core.IsEqual.equalTo;
import static org.junit.Assert.*;

public class BibliotecaAppTest {
    private BibliotecaApp Main;
    private BookList bookList;
    private MovieList movieList;

    @Before
    public void init(){
        Main = new BibliotecaApp();
        bookList = new BookList();
        movieList = new MovieList();
    }



}