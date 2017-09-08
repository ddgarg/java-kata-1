package org.echocat.kata.java.part1.exceptions;

/**
 * Created by dindayal on 08/09/17.
 */
public class BookNotFound extends RuntimeException {

    public BookNotFound(String message) {
        super(message);
    }
}
