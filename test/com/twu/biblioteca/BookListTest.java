package com.twu.biblioteca;

import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;

import static org.hamcrest.core.IsEqual.equalTo;
import static org.junit.Assert.*;

public class BookListTest {
    private BookList Main;

    @Before
    public void init(){
        this.Main = new BookList();
    }

    @Test
    public void printDetailList(){
        assertThat(Main.printDetailList(), equalTo(" "));
    }

    @Test
    public void printOverviewList(){
        assertThat(Main.printOverviewList(), equalTo(" "));
    }
}