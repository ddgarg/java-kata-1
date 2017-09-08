package org.echocat.kata.java.part1.service;

import org.echocat.kata.java.part1.database.MagazineDao;
import org.echocat.kata.java.part1.exceptions.BookNotFound;
import org.echocat.kata.java.part1.models.BookBase;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/**
 * Created by dindayal on 08/09/17.
 */
public class MagazineServiceImpl implements MagazineService {

    private MagazineDao magazineDao;

    public MagazineServiceImpl(MagazineDao magazineDao) {
        this.magazineDao = magazineDao;
    }

    @Override
    public BookBase findMagazineByISBN(String isbn) {
        List<BookBase> magazines = magazineDao.getAllMagazines();

        for (BookBase magazine : magazines) {
            if (magazine.getIsbn().equals(isbn)) {
                return magazine;
            }
        }
        throw new BookNotFound("Magazine Not found");
    }

    @Override
    public List<BookBase> findMagazineByAuthorEmail(String email) {
        List<BookBase> magazines = magazineDao.getAllMagazines();
        List<BookBase> filteredMagazines = new ArrayList<>();

        for (BookBase magazine : magazines) {
            if (magazine.getAuthors().indexOf(email) > -1) {
                filteredMagazines.add(magazine);
            }
        }

        return filteredMagazines;
    }

    @Override
    public List<BookBase> getAllMagazine() {
        return magazineDao.getAllMagazines();
    }

    @Override
    public List<BookBase> getAllMagazineSortedByTitle() {
        List<BookBase> magazines = new ArrayList<>(magazineDao.getAllMagazines());


        Collections.sort(magazines, new Comparator<BookBase>() {
            @Override
            public int compare(BookBase o1, BookBase o2) {
                return o1.getTitle().compareTo(o2.getTitle());
            }
        });

        return magazines;
    }
}
