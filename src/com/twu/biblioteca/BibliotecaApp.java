package com.twu.biblioteca;


import java.util.ArrayList;
import java.util.Scanner;

import static java.lang.System.exit;

public class BibliotecaApp {
    private BookList bookList;

    public BibliotecaApp() {
        bookList = new BookList();
    }

    private String welcome() {
        String output = "Welcome to Biblioteca. Your one-stop-shop for great book titles in Bangalore!";
        System.out.println(output);
        System.out.println();
        return output;
    }

    private void showMenu() {
        System.out.println("*****************************************");
        System.out.println("************ Control Panel **************");
        System.out.println("*****************************************");
        System.out.println();
        System.out.println("Enter 1 to see the list of all library books.");
        System.out.println("Enter 2 to see the list of all library books in detail");
        System.out.println("Enter 3 to borrow your favorite books.");
        System.out.println("Enter 4 to return books you borrowed before.");
        System.out.println("Enter 0 to quit Biblioteca Application");
        System.out.println();
        System.out.println("*****************************************");
    }

    private void sayGoodBye() {
        System.out.println("*****************************************");
        System.out.println("****** Thanks for using Biblioteca ******");
        System.out.println("************** Bye Bye! *****************");
    }

    private void waitForEnterAnyKey(Scanner input) {
        System.out.println("Enter any key to return Control Panel");
        input.next();
    }

    public void run() {
        try {
            Thread.sleep(1500);
        } catch(Exception e) {
            e.printStackTrace();
        }

        Scanner input = new Scanner(System.in);
        int option;
        while(true) {
            showMenu();
            try {
                option = input.nextInt();
            } catch (Exception e) {
                System.out.println("Please select a valid options!");
                continue;
            }
            switch (option) {
                case 1:
                    bookList.printOverviewList();
                    waitForEnterAnyKey(input);
                    break;
                case 2:
                    bookList.printDetailList();
                    waitForEnterAnyKey(input);
                    break;
                case 3:
                    System.out.println("Please enter bookId to borrow a book");
                    String str = input.next();
                    bookList.borrowBookById(str);
                    waitForEnterAnyKey(input);
/*                    if(str.matches("#[0-9]*"))
                        bookList.borrowBookById(str);
                    else
                        bookList.borrowBookByName(str);
                        */

                    break;
                case 4:
                    System.out.println("Please enter bookId to return a book");
                    bookList.returnBookById(input.next());
                    waitForEnterAnyKey(input);
                    break;
                case 0:
                    sayGoodBye();
                    exit(1);
                default:
                    System.out.println("Please select a valid options!");
            }

        }
    }

    public static void main(String[] args) {
        BibliotecaApp Main = new BibliotecaApp();
        Main.welcome();
        Main.run();
    }
}