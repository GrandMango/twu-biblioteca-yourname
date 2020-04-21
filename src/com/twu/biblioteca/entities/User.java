package com.twu.biblioteca.entities;

public class User {
    private String username;
    private String password;

    public User(String username, String password) {
        this.username = username;
        this.password = password;
    }

    public User(String[] arr) {
        if(arr.length != 2){
            System.out.println("ERROR: User Initial Error, invalid input");
        } else {
            username = arr[0];
            password = arr[1];
        }
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
}
