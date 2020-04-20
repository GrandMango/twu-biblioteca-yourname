package com.twu.biblioteca;

public class Book {
    private String id;
    private String bookName;
    private String authorName;
    private String publishYear;

    public Book() {
        this.id = "###";
        this.bookName = "None";
        this.authorName = "None";
        this.publishYear = "None";
    }

    public Book(String id, String bookName, String authorName, String publishYear) {
        this.id = id;
        this.bookName = bookName;
        this.authorName = authorName;
        this.publishYear = publishYear;
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
}
