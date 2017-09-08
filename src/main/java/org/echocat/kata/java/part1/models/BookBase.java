package org.echocat.kata.java.part1.models;

import java.util.List;

/**
 * Created by dindayal on 08/09/17.
 */
public class BookBase {

    private String title;
    private String isbn;
    private List<String> authors;

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getIsbn() {
        return isbn;
    }

    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }

    public List<String> getAuthors() {
        return authors;
    }

    public void setAuthors(List<String> authors) {
        this.authors = authors;
    }
}
