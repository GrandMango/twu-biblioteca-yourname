package com.twu.biblioteca;

public class BibliotecaApp {


    public String welcome(){
        System.out.println("*****************************************");
        String output = "Welcome to Biblioteca. Your one-stop-shop for great book titles in Bangalore!";
        System.out.println("*****************************************");
        System.out.println(output);
        return output;
    }

    public void showMenu(){
        System.out.println("*****************************************");
        System.out.println("************ Control Panel **************");
        System.out.println("*****************************************");
        System.out.println("Enter 1 to see the list of all library books.");
        System.out.println("Enter 2 to see the list of all library books in detail");
        System.out.println("Enter 3 to borrow your favorite books.");
        System.out.println("Enter 4 to return books you borrowed before.");
        System.out.println("Enter 0 to quit Biblioteca Application");
        System.out.println("*****************************************");
    }


    public static void main(String[] args) {

    }
}
