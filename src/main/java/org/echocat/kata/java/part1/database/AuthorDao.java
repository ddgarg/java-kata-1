package org.echocat.kata.java.part1.database;

import org.echocat.kata.java.part1.models.Person;

import java.util.List;

/**
 * Created by dindayal on 08/09/17.
 */
public interface AuthorDao {
    List<Person> getAllAuthors();

    Person getAuthorByEmail(String email);
}
