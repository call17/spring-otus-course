package ru.otus.homework1.dao;

import com.opencsv.CSVReader;
import org.springframework.stereotype.Repository;

import java.io.*;
import java.util.List;

@Repository
public class CsvDao {

    public List<String[]> readFile() {
        {
            CSVReader reader = null;
            ClassLoader classLoader = getClass().getClassLoader();
            File file = new File(classLoader.getResource("answers.csv").getFile());
            try {
                reader = new CSVReader(new FileReader(file), ',', '"', 1);
            } catch (FileNotFoundException e) {
                e.printStackTrace();
            }
            List<String[]> allRows = null;
            try {
                allRows = reader.readAll();
            } catch (IOException e) {
                e.printStackTrace();
            }

            return allRows;
        }
    }
}
