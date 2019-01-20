package ru.otus.homework1.dao;

import com.opencsv.CSVReader;
import org.springframework.stereotype.Repository;

import java.io.*;
import java.util.List;
import java.util.Locale;

@Repository
public class CsvDao {

    public List<String[]> readFile() {
        {
            CSVReader reader = null;
            ClassLoader classLoader = getClass().getClassLoader();
            String localeCode = Locale.getDefault().toLanguageTag();
            File file = new File(classLoader.getResource("answers_" + localeCode + ".csv").getFile());
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
