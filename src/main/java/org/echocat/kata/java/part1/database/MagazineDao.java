package org.echocat.kata.java.part1.database;

import org.echocat.kata.java.part1.models.BookBase;

import java.util.List;

/**
 * Created by dindayal on 08/09/17.
 */
public interface MagazineDao {
    List<BookBase> getAllMagazines();
}
