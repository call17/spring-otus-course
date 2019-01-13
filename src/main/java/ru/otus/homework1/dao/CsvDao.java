package ru.otus.homework1.dao;

import com.opencsv.CSVReader;
import org.apache.commons.lang3.ArrayUtils;
import org.springframework.stereotype.Repository;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import static java.util.Locale.ENGLISH;

@Repository
public class CsvDao {

    private static final int RU_INDEX = 0;
    private static final int EN_INDEX = 1;

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

            List<String[]> finalRows = new ArrayList<>();
            if (Locale.getDefault().equals(ENGLISH)){
                allRows.forEach(strings -> finalRows.add(ArrayUtils.removeElement(strings,strings[RU_INDEX])));
            }else {
                allRows.forEach(strings -> finalRows.add(ArrayUtils.removeElement(strings,strings[EN_INDEX])));
            }

            return finalRows;
        }
    }
}
