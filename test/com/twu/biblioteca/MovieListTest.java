package com.twu.biblioteca;

import org.junit.Before;
import org.junit.Test;

import static org.hamcrest.core.IsEqual.equalTo;
import static org.junit.Assert.*;

public class MovieListTest {
    private MovieList movieList;

    @Before
    public void init(){
        this.movieList = new MovieList();
    }

    @Test
    public void printDetailList(){
        assertThat(movieList.printDetailList(), equalTo(9));
    }

    @Test
    public void printOverviewList(){
        assertThat(movieList.printOverviewList(), equalTo(9));
    }

    @Test
    public void isMovieAvailabelById(){
        assertThat(movieList.borrowMovieById("#003"), equalTo(true));
        assertThat(movieList.borrowMovieById("#006"), equalTo(false));
    }

    @Test
    public void isMovieAvailabelByName(){
        assertThat(movieList.borrowMovieByName("The Goblet of Fire"), equalTo(true));
        assertThat(movieList.borrowMovieByName("The Half-Blood Prince"), equalTo(false));
    }


}