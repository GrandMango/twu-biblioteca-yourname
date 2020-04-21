package com.twu.biblioteca;

public class Book {
    private String id;
    private String bookName;
    private String authorName;
    private String publishYear;
    private String isAvailable;

    public Book() {
        this.id = "###";
        this.bookName = "None";
        this.authorName = "None";
        this.publishYear = "None";
        this.isAvailable = "Unavailable";
    }

    public Book(String id, String bookName, String authorName, String publishYear, String isAvailable) {
        this.id = id;
        this.bookName = bookName;
        this.authorName = authorName;
        this.publishYear = publishYear;
        this.isAvailable = isAvailable;
    }

    public Book(String[] arr) {
        if(arr.length != 5){
            System.out.println("ERROR: Book Initial Error, invalid input");
        } else {
            id = arr[0];
            bookName = arr[1];
            authorName = arr[2];
            publishYear = arr[3];
            isAvailable = arr[4];
        }
    }

    public String getId() {
        return id;
    }

    public String getBookName() {
        return bookName;
    }

    public String getAuthorName() {
        return authorName;
    }

    public String getPublishYear() {
        return publishYear;
    }

    public void setId(String id) {
        this.id = id;
    }

    public void setBookName(String bookName) {
        this.bookName = bookName;
    }

    public void setAuthorName(String authorName) {
        this.authorName = authorName;
    }

    public void setPublishYear(String publishYear) {
        this.publishYear = publishYear;
    }

    public String getIsAvailable() {
        return isAvailable;
    }

    public void setIsAvailable(String isAvailable) {
        this.isAvailable = isAvailable;
    }
}
