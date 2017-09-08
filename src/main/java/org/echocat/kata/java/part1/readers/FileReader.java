package org.echocat.kata.java.part1.readers;

import java.io.IOException;
import java.util.List;

/**
 * Created by dindayal on 08/09/17.
 */
public interface FileReader {
    List<String> readFile(String fileName) throws IOException;
}
