package org.echocat.kata.java.part1.database;

import org.echocat.kata.java.part1.models.Book;
import org.echocat.kata.java.part1.models.BookBase;
import org.echocat.kata.java.part1.readers.FileReader;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by dindayal on 08/09/17.
 */
public class BookDaoImpl implements BookDao {

    private FileReader fileReader;

    public BookDaoImpl(FileReader fileReader) {
        this.fileReader = fileReader;
    }

    @Override
    public List<BookBase> getAllBooks() {
        List<BookBase> books = new ArrayList<>();
        try {
            List<String> data = fileReader.readFile("org/echocat/kata/java/part1/data/books.csv");
            for (String row : data) {
                String[] booksFields = row.split(";");
                Book book = new Book();
                book.setTitle(booksFields[0]);
                book.setIsbn(booksFields[1]);
                book.setAuthors(Arrays.asList(booksFields[2].split(",")));
                book.setDescription(booksFields[3]);

                books.add(book);

            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        return books;
    }

    public void setFileReader(FileReader fileReader) {
        this.fileReader = fileReader;
    }
}
