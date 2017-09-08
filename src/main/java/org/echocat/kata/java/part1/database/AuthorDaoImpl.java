package org.echocat.kata.java.part1.database;

import org.echocat.kata.java.part1.models.Author;
import org.echocat.kata.java.part1.models.Person;
import org.echocat.kata.java.part1.readers.FileReader;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by dindayal on 08/09/17.
 */
public class AuthorDaoImpl implements AuthorDao {
    private FileReader fileReader;

    public AuthorDaoImpl(FileReader fileReader) {
        this.fileReader = fileReader;
    }

    @Override
    public List<Person> getAllAuthors() {
        List<Person> authors = new ArrayList<>();
        try {
            List<String> data = fileReader.readFile("org/echocat/kata/java/part1/data/authors.csv");
            for (String row : data) {
                String[] authorFields = row.split(";");
                Author author = new Author();
                author.setEmail(authorFields[0]);
                author.setFirstName(authorFields[1]);
                author.setLastName(authorFields[2]);
                authors.add(author);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        return authors;
    }

    @Override
    public Person getAuthorByEmail(String email) {
        return null;
    }

    public void setFileReader(FileReader fileReader) {
        this.fileReader = fileReader;
    }
}
