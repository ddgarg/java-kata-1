package org.echocat.kata.java.part1.database;

import org.echocat.kata.java.part1.models.BookBase;
import org.echocat.kata.java.part1.models.Magazine;
import org.echocat.kata.java.part1.readers.FileReader;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by dindayal on 08/09/17.
 */
public class MagazineDaoImpl implements MagazineDao {

    private FileReader fileReader;

    public MagazineDaoImpl(FileReader fileReader) {
        this.fileReader = fileReader;
    }

    @Override
    public List<BookBase> getAllMagazines() {
        List<BookBase> magazines = new ArrayList<>();
        try {
            List<String> data = fileReader.readFile("org/echocat/kata/java/part1/data/magazines.csv");
            for (String row : data) {
                String[] booksFields = row.split(";");
                Magazine magazine = new Magazine();
                magazine.setTitle(booksFields[0]);
                magazine.setIsbn(booksFields[1]);
                magazine.setAuthors(Arrays.asList(booksFields[2].split(",")));
                magazine.setPublishedAt(booksFields[3]);

                magazines.add(magazine);

            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        return magazines;
    }

    public void setFileReader(FileReader fileReader) {
        this.fileReader = fileReader;
    }
}
