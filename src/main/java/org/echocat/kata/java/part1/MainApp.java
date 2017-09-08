package org.echocat.kata.java.part1;

import org.echocat.kata.java.part1.database.*;
import org.echocat.kata.java.part1.models.Book;
import org.echocat.kata.java.part1.models.BookBase;
import org.echocat.kata.java.part1.models.Magazine;
import org.echocat.kata.java.part1.models.Person;
import org.echocat.kata.java.part1.readers.CSVFileReader;
import org.echocat.kata.java.part1.readers.FileReader;
import org.echocat.kata.java.part1.service.*;

import java.util.List;
import java.util.Scanner;

@SuppressWarnings("UseOfSystemOutOrSystemErr")
public class MainApp {

    public static void main(String[] args) {
        FileReader fileReader = new CSVFileReader();
        AuthorDao authorDao = new AuthorDaoImpl(fileReader);
        BookDao bookDao = new BookDaoImpl(fileReader);
        MagazineDao magazineDao = new MagazineDaoImpl(fileReader);

        AuthorService authorService = new AuthorServiceImpl(authorDao);
        BookService bookService = new BookServiceImpl(bookDao);
        MagazineService magazineService = new MagazineServiceImpl(magazineDao);

        Scanner scanner = new Scanner(System.in);
        while (true) {
            System.out.println("Enter one of the below option");
            System.out.println("1 - Print All books");
            System.out.println("2 - Print All Magazines");
            System.out.println("3 - Find Book by ISBN");
            System.out.println("4 - Find Magazines by ISBN");
            System.out.println("5 - Find All Books by Email");
            System.out.println("6 - Find All Magazines by Email");
            System.out.println("7 - Find All Book Sorted by Title");
            System.out.println("8 - Find All Magazine Sorted by Title");

            Integer input = scanner.nextInt();

            if (input == 1) {
                List<BookBase> books = bookService.getAllBook();

                for (BookBase baseBook : books) {
                    Book book = (Book) baseBook;
                    System.out.println("Title :  " + book.getTitle());
                    System.out.println("ISBN Number :  " + book.getIsbn());
                    System.out.println("Description :  " + book.getDescription());
                    System.out.println("Authors :  ");
                    printAuthors(authorService, book);
                }
            } else if (input == 2) {
                List<BookBase> magazines = magazineService.getAllMagazine();

                for (BookBase baseBook : magazines) {
                    Magazine magazine = (Magazine) baseBook;
                    System.out.println("Title :  " + magazine.getTitle());
                    System.out.println("ISBN Number :  " + magazine.getIsbn());
                    System.out.println("Published Date :  " + magazine.getPublishedAt());
                    System.out.println("Authors :  ");
                    printAuthors(authorService, magazine);
                }
            } else if (input == 3) {
                System.out.println("Enter ISBN");
                Book book = (Book) bookService.findBookByISBN(scanner.nextLine());
                System.out.println("Title :  " + book.getTitle());
                System.out.println("ISBN Number :  " + book.getIsbn());
                System.out.println("Description :  " + book.getDescription());
                System.out.println("Authors :  ");
                printAuthors(authorService, book);
            } else if (input == 4) {
                System.out.println("Enter ISBN");
                Magazine magazine = (Magazine) magazineService.findMagazineByISBN(scanner.nextLine());
                System.out.println("Title :  " + magazine.getTitle());
                System.out.println("ISBN Number :  " + magazine.getIsbn());
                System.out.println("Publisged Date :  " + magazine.getPublishedAt());
                System.out.println("Authors :  ");
                printAuthors(authorService, magazine);
            }
        }
    }

    private static void printAuthors(AuthorService authorService, BookBase magazine) {
        for (String email : magazine.getAuthors()) {
            Person author = authorService.findAuthorByEmail(email);

            System.out.println("Email :  " + author.getEmail());
            System.out.println("First Name :  " + author.getFirstName());
            System.out.println("Last Name :  " + author.getLastName());
        }
    }

}
