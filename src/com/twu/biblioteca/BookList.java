package com.twu.biblioteca;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class BookList {
    private ArrayList<Book> bookList;
    private String filePath="resources/book_list.csv";

    public BookList() {
        bookList = readFile();
    }

    private ArrayList<Book> readFile() {
        String line = null;
        ArrayList<Book> list = new ArrayList<Book>();

        try {
            File file = new File(filePath);
            BufferedReader reader = new BufferedReader(new FileReader(file));
            while((line = reader.readLine()) != null) {
                String[] arr = line.split(",");
                list.add(new Book(arr));
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return list;
    }


    public int  printOverviewList() {
        System.out.printf("* " + "%-6s", "Id");
        System.out.printf("* " + "%-30s", "Book_Name");
        System.out.printf("* " + "%-10s", "Status");
        System.out.println("*");

        int count = 0;
        for (Book book:bookList) {
            if(book.getIsAvailable().equals("Available")) {
                System.out.printf("| " + "%-6s", book.getId());
                System.out.printf("| " + "%-30s", book.getBookName());
                System.out.printf("| " + "%-10s", book.getIsAvailable());
                System.out.println("|");
                count++;
            }
        }
        System.out.println("Find " + count + " available books.");
        return count;
    }

    public int  printDetailList() {
        System.out.printf("* " + "%-6s", "Id");
        System.out.printf("* " + "%-30s", "Book_Name");
        System.out.printf("* " + "%-15s", "Author_Name");
        System.out.printf("* " + "%-5s", "Year");
        System.out.printf("* " + "%-10s", "Status");
        System.out.println("*");

        int count = 0;
        for (Book book:bookList) {
            if(book.getIsAvailable().equals("Available")) {
                System.out.printf("| " + "%-6s", book.getId());
                System.out.printf("| " + "%-30s", book.getBookName());
                System.out.printf("| " + "%-15s", book.getAuthorName());
                System.out.printf("| " + "%-5s", book.getPublishYear());
                System.out.printf("| " + "%-10s", book.getIsAvailable());
                System.out.println("|");
                count++;
            }
        }
        System.out.println("Find " + count + " available books.");
        return count;
    }

    public Book findBookById(String id){
        for (Book book : bookList){
            if (book.getId().equals(id)) {
                return book;
            }
        }
        return null;
    }

    public Book findBookByName(String bookName){
        for (Book book : bookList){
            if (book.getBookName().equals(bookName)) {
                return book;
            }
        }
        return null;
    }

    public boolean borrowBookById(String id) {
        Book book = findBookById(id);
        if(book != null && book.getIsAvailable().equals("Available")) {
            borrowBook(book);
            System.out.println("Thank you!Enjoy your book");
            return true;
        } else {
            System.out.println("Sorry, that book is not available");
            return false;
        }
    }

    public boolean borrowBookByName(String bookName) {
        Book book = findBookByName(bookName);
        if(book != null && book.getIsAvailable().equals("Available")) {
            borrowBook(book);
            System.out.println("Thank you!Enjoy your book");
            return true;
        } else {
            System.out.println("Sorry, that book is not available");
            return false;
        }
    }

    public boolean returnBookById(String id) {
        Book book = findBookById(id);
        if(book != null && book.getIsAvailable().equals("Unavailable")) {
            returnBook(book);
            System.out.println("Thank you for returning the book");
            return true;
        } else {
            System.out.println("That is not a valid book to return");
            return false;
        }
    }

    public void borrowBook(Book book){
        book.setIsAvailable("Unavailable");
    }

    public void returnBook(Book book){
        book.setIsAvailable("Available");
    }
}
