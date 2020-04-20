package com.twu.biblioteca;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class BookList {
    private ArrayList<Book> bookList;
    private String filePath="resources/book_list.csv";

    public BookList(){
        bookList = readFile();
    }

    private ArrayList<Book> readFile(){
        String line = null;
        ArrayList<Book> list = new ArrayList<Book>();

        try {
            File file = new File(filePath);
            BufferedReader reader = new BufferedReader(new FileReader(file));
            while((line = reader.readLine()) != null){
                String[] arr = line.split(",");
                list.add(new Book(arr));
            }
        } catch (IOException e){
            e.printStackTrace();
        }
        return list;
    }

    public String  printList() {
        System.out.printf("* " + "%-6s", "Id");
        System.out.printf("* " + "%-30s", "Book_Name");
        System.out.printf("* " + "%-15s", "Author_Name");
        System.out.printf("* " + "%-5s", "Year");
        System.out.printf("* " + "%-10s", "Status");
        System.out.println("*");

        for (Book book:bookList) {
            if(book.getIsAvailable().equals("Available")) {
                System.out.printf("| " + "%-6s", book.getId());
                System.out.printf("| " + "%-30s", book.getBookName());
                System.out.printf("| " + "%-15s", book.getAuthorName());
                System.out.printf("| " + "%-5s", book.getPublishYear());
                System.out.printf("| " + "%-10s", book.getIsAvailable());
                System.out.println("|");
            }
        }
        System.out.println("Find " + bookList.size() + " available books.");
        return " ";
    }
}
