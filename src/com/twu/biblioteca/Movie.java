package com.twu.biblioteca;

public class Movie {
    private String id;
    private String movieName;
    private String directorName;
    private String publishYear;
    private String rating;
    private String isAvailable;

    public Movie() {
    }

    public Movie(String id, String movieName, String directorName, String publishYear, String rating, String isAvailable) {
        this.id = id;
        this.movieName = movieName;
        this.directorName = directorName;
        this.publishYear = publishYear;
        this.rating = rating;
        this.isAvailable = isAvailable;
    }

    public Movie(String[] arr) {
        if(arr.length != 6){
            System.out.println("ERROR: Movie Initial Error, invalid input");
        } else {
            id = arr[0];
            movieName = arr[1];
            directorName = arr[2];
            publishYear = arr[3];
            rating = arr[4];
            isAvailable = arr[5];
        }
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getMovieName() {
        return movieName;
    }

    public void setMovieName(String movieName) {
        this.movieName = movieName;
    }

    public String getDirectorName() {
        return directorName;
    }

    public void setDirectorName(String directorName) {
        this.directorName = directorName;
    }

    public String getPublishYear() {
        return publishYear;
    }

    public void setPublishYear(String publishYear) {
        this.publishYear = publishYear;
    }

    public String getRating() {
        return rating;
    }

    public void setRating(String rating) {
        this.rating = rating;
    }

    public String getIsAvailable() {
        return isAvailable;
    }

    public void setIsAvailable(String isAvailable) {
        this.isAvailable = isAvailable;
    }
}

