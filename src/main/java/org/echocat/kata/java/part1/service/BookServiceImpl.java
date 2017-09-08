package org.echocat.kata.java.part1.service;

import org.echocat.kata.java.part1.database.BookDao;
import org.echocat.kata.java.part1.exceptions.BookNotFound;
import org.echocat.kata.java.part1.models.BookBase;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/**
 * Created by dindayal on 08/09/17.
 */
public class BookServiceImpl implements BookService {

    private BookDao bookDao;

    public BookServiceImpl(BookDao bookDao) {
        this.bookDao = bookDao;
    }

    @Override
    public BookBase findBookByISBN(String isbn) {
        List<BookBase> books = bookDao.getAllBooks();

        for (BookBase book : books) {
            if (book.getIsbn().equals(isbn)) {
                return book;
            }
        }
        throw new BookNotFound("Book Not found");
    }

    @Override
    public List<BookBase> findBookByAuthorEmail(String email) {
        List<BookBase> books = bookDao.getAllBooks();
        List<BookBase> filteredBooks = new ArrayList<>();

        for (BookBase book : books) {
            if (book.getAuthors().indexOf(email) > -1) {
                filteredBooks.add(book);
            }
        }

        return filteredBooks;
    }

    @Override
    public List<BookBase> getAllBook() {
        return bookDao.getAllBooks();
    }

    @Override
    public List<BookBase> getAllBookSortedByTitle() {

        List<BookBase> books = new ArrayList<>(bookDao.getAllBooks());


        Collections.sort(books, new Comparator<BookBase>() {
            @Override
            public int compare(BookBase o1, BookBase o2) {
                return o1.getTitle().compareTo(o2.getTitle());
            }
        });

        return books;

    }
}
