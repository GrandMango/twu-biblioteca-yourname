package com.twu.biblioteca;


import com.twu.biblioteca.entities.User;

import java.util.Scanner;

import static java.lang.System.exit;

public class BibliotecaApp {
    private BookList bookList;
    private MovieList movieList;
    private User currentUser;
    private AuthenticationService authenticationService;
    private Scanner input;

    public BibliotecaApp() {
        bookList = new BookList();
        movieList = new MovieList();
        currentUser = null;
        authenticationService = new AuthenticationService();
        input = new Scanner(System.in);
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
        System.out.println("Welcome " + authenticationService.getCurrentUser().getUsername() + "!");
        System.out.println("Enter 1 to see the list of all library books.");
        System.out.println("Enter 2 to see the list of all library books in detail.");
        System.out.println("Enter 3 to see the list of all library movie resources.");
        System.out.println("Enter 4 to borrow your favorite book.");
        System.out.println("Enter 5 to return book you borrowed before.");
        System.out.println("Enter 6 to borrow your favorite movie.");
        System.out.println("Enter 7 to return movie you borrowed before.");
        System.out.println("Enter 0 to quit Biblioteca Application");
        System.out.println();
        System.out.println("*****************************************");
    }

    private void sayGoodBye() {
        System.out.println("*****************************************");
        System.out.println("****** Thanks for using Biblioteca ******");
        System.out.println("************** Bye Bye! *****************");
    }

    private void waitForEnterReturnKey(Scanner input) {
        System.out.println("Enter 'q' to return Control Panel");
        input.next();
    }

    private void doLogin(){
        System.out.println("Please enter your username and password!");
        while(true) {
            System.out.printf("username: ");
            Scanner input = new Scanner(System.in);
            String username = input.nextLine();
            System.out.printf("password: ");
            String password = input.nextLine();

            if (authenticationService.login(username, password) == true)
                return;
        }
    }

    public void run() {
        doLogin();

        int option;
        while(true) {
            showMenu();
            try {
                option = input.nextInt();
            } catch (Exception e) {
                System.out.println("Please select a valid options!");
                input.nextLine();
                continue;
            }
            switch (option) {
                case 1:
                    bookList.printOverviewList();
                    waitForEnterReturnKey(input);
                    break;
                case 2:
                    bookList.printDetailList();
                    waitForEnterReturnKey(input);
                    break;
                case 3:
                    movieList.printDetailList();
                    waitForEnterReturnKey(input);
                    break;
                case 4:
                    System.out.println("Please enter bookId or bookName to borrow a book");
                    borrowBook();
                    waitForEnterReturnKey(input);
                    break;
                case 5:
                    System.out.println("Please enter bookId to return a book");
                    returnBook();
                    waitForEnterReturnKey(input);
                    break;
                case 6:
                    System.out.println("Please enter movieId to borrow a movie");
                    movieList.borrowMovieById(input.next());
                    waitForEnterReturnKey(input);
                    break;
                case 7:
                    System.out.println("Please enter movieId to return a movie");
                    movieList.returnMovieById(input.next());
                    waitForEnterReturnKey(input);
                    break;


                case 0:
                    sayGoodBye();
                    exit(1);
                default:
                    System.out.println("Please select a valid options!");
            }

        }
    }

    private void borrowBook() {
        input.nextLine();
        String str = input.nextLine();

        if(str.matches("#[0-9]*")) {
            bookList.borrowBookById(str);
            authenticationService.getCurrentUser().addBorrowedBook(
                    bookList.findBookById(str));
        } else {
            bookList.borrowBookByName(str);
            authenticationService.getCurrentUser().addBorrowedBook(
                    bookList.findBookByName(str));
        }
    }

    private void returnBook() {
        bookList.returnBookById(input.next());
    }

    public static void main(String[] args) {
        BibliotecaApp Main = new BibliotecaApp();
        Main.welcome();
        Main.run();
    }
}
