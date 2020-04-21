package com.twu.biblioteca.entities;

import java.util.ArrayList;

public class User {
    private String username;
    private String password;
    private String email;
    private ArrayList<Book> borrowedBooks;

    public User(String username, String password, String email) {
        this.username = username;
        this.password = password;
        this.email = email;
        borrowedBooks = new ArrayList<Book>();
    }

    public User(String[] arr) {
        if(arr.length != 3){
            System.out.println("ERROR: User Initial Error, invalid input");
        } else {
            username = arr[0];
            password = arr[1];
            email = arr[2];
        }
    }

    public void addBorrowedBook(Book book){
        borrowedBooks.add(book);
    }

    public void returnBorrowedBook(Book book){
        borrowedBooks.remove(book);
    }
    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
