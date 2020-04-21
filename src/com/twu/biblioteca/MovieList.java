package com.twu.biblioteca;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class MovieList {
    private ArrayList<Movie> movieList;
    private String filePath="resources/movie_list.csv";

    public MovieList(){
        movieList = readFile();
    }
    private ArrayList<Movie> readFile() {
        String line = null;
        ArrayList<Movie> list = new ArrayList<Movie>();

        try {
            File file = new File(filePath);
            BufferedReader reader = new BufferedReader(new FileReader(file));
            while((line = reader.readLine()) != null) {
                String[] arr = line.split(",");
                list.add(new Movie(arr));
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return list;
    }

    public int  printOverviewList() {
        System.out.printf("* " + "%-6s", "Id");
        System.out.printf("* " + "%-30s", "Movie_Name");
        System.out.printf("* " + "%-10s", "Status");
        System.out.println("*");

        int count = 0;
        for (Movie movie:movieList) {
            if(movie.getIsAvailable().equals("Available")) {
                System.out.printf("| " + "%-6s", movie.getId());
                System.out.printf("| " + "%-30s", movie.getMovieName());
                System.out.printf("| " + "%-10s", movie.getIsAvailable());
                System.out.println("|");
                count++;
            }
        }
        System.out.println("Find " + count + " available movies.");
        return count;
    }

    public int  printDetailList() {
        System.out.printf("* " + "%-6s", "Id");
        System.out.printf("* " + "%-30s", "Movie_Name");
        System.out.printf("* " + "%-15s", "Director_Name");
        System.out.printf("* " + "%-5s", "Year");
        System.out.printf("* " + "%-7s", "Rating");
        System.out.printf("* " + "%-10s", "Status");
        System.out.println("*");

        int count = 0;
        for (Movie movie:movieList) {
            if(movie.getIsAvailable().equals("Available")) {
                System.out.printf("| " + "%-6s", movie.getId());
                System.out.printf("| " + "%-30s", movie.getMovieName());
                System.out.printf("| " + "%-15s", movie.getDirectorName());
                System.out.printf("| " + "%-5s", movie.getPublishYear());
                System.out.printf("| " + "%-7s", movie.getRating());
                System.out.printf("| " + "%-10s", movie.getIsAvailable());
                System.out.println("|");
                count++;
            }
        }
        System.out.println("Find " + count + " available movies.");
        return count;
    }

    public boolean borrowMovieById(String id) {
        for (Movie movie : movieList){
            if (movie.getId().equals(id)
                    && movie.getIsAvailable().equals("Available")) {
                borrowMovie(movie);
                System.out.println("Thank you!Enjoy your movie");
                return true;
            }
        }
        System.out.println("Sorry, that movie is not available");
        return false;
    }

    public boolean borrowMovieByName(String movieName) {
        for (Movie movie : movieList){
            if (movie.getMovieName().equals(movieName)
                    && movie.getIsAvailable().equals("Available")) {
                borrowMovie(movie);
                System.out.println("Thank you!Enjoy your movie");
                return true;
            }
        }
        System.out.println("Sorry, that movie is not available");
        return false;
    }

    public boolean returnMovieById(String id) {
        for (Movie movie : movieList){
            if (movie.getId().equals(id)
                    && movie.getIsAvailable().equals("Unavailable")) {
                returnMovie(movie);
                System.out.println("Thank you for returning the movie");
                return true;
            }
        }
        System.out.println("That is not a valid movie to return");
        return false;
    }

    public void borrowMovie(Movie movie){
        movie.setIsAvailable("Unavailable");
    }

    public void returnMovie(Movie movie){
        movie.setIsAvailable("Available");
    }

}
