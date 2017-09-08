package org.echocat.kata.java.part1.readers;

import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class CSVFileReader implements FileReader {

    @Override
    public List<String> readFile(String fileName) throws IOException {

        List<String> data = new ArrayList<>();
        BufferedReader br = new BufferedReader(new java.io.FileReader(new File("").getAbsolutePath() +
                "/src/main/resources/" + fileName));
        String line;
        br.readLine();
        while ((line = br.readLine()) != null && !line.isEmpty()) {
            data.add(line);
        }
        br.close();
        return data;
    }
}
