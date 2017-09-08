package org.echocat.kata.java.part1.service;

import org.echocat.kata.java.part1.models.BookBase;

import java.util.List;

/**
 * Created by dindayal on 08/09/17.
 */
public interface BookService {

    BookBase findBookByISBN(String isbn);

    List<BookBase> findBookByAuthorEmail(String email);

    List<BookBase> getAllBook();

    List<BookBase> getAllBookSortedByTitle();

}
