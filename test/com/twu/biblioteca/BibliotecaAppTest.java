package com.twu.biblioteca;

import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;

import static org.hamcrest.core.IsEqual.equalTo;
import static org.junit.Assert.*;

public class BibliotecaAppTest {
    private BibliotecaApp Main;

    @Before
    public void init(){
        this.Main = new BibliotecaApp();
    }

    @Test
    public void testWelcomeMessage(){
        assertThat(Main.welcome(), equalTo("Welcome to Biblioteca. Your one-stop-shop for great book titles in Bangalore!"));
    }

/*    @Ignore
    public void testMenuInfo(){
        assertThat(Main.);
    }*/
}