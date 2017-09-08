package org.echocat.kata.java.part1.service;

import org.echocat.kata.java.part1.models.BookBase;

import java.util.List;

/**
 * Created by dindayal on 08/09/17.
 */
public interface MagazineService {
    BookBase findMagazineByISBN(String isbn);

    List<BookBase> findMagazineByAuthorEmail(String email);

    List<BookBase> getAllMagazine();

    List<BookBase> getAllMagazineSortedByTitle();
}
