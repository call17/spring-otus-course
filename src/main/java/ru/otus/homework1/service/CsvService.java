package ru.otus.homework1.service;

import ru.otus.homework1.dao.CsvDao;
import ru.otus.homework1.model.Question;

import java.util.ArrayList;
import java.util.List;

public class CsvService {
    private CsvDao csvDao;

    public CsvService(CsvDao csvDao){
        this.csvDao = csvDao;
    }

    public List<Question> getAnswerList(){
        List<String[]> csvStrings = csvDao.readFile();
        List<Question> questionList = new ArrayList<>();
        csvStrings.forEach((strings -> questionList.add(new Question(strings[0],strings[1]))));
        return questionList;
    }
}
