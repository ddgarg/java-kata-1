package org.echocat.kata.java.part1.service;

import org.echocat.kata.java.part1.models.Person;

public interface AuthorService {
    Person findAuthorByEmail(String email);
}
