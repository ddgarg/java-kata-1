package org.echocat.kata.java.part1.service;

import org.echocat.kata.java.part1.database.AuthorDao;
import org.echocat.kata.java.part1.exceptions.AuthorNotFoundException;
import org.echocat.kata.java.part1.models.Person;

import java.util.List;

/**
 * Created by dindayal on 08/09/17.
 */
public class AuthorServiceImpl implements AuthorService {

    private AuthorDao authorDao;

    public AuthorServiceImpl(AuthorDao authorDao) {
        this.authorDao = authorDao;
    }

    @Override
    public Person findAuthorByEmail(String email) {
        List<Person> authors = authorDao.getAllAuthors();

        for (Person author : authors) {
            if (author.getEmail().equals(email))
                return author;
        }

        throw new AuthorNotFoundException("Author Not Found exception");
    }
}
