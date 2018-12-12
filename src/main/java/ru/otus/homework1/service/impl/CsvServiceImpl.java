package ru.otus.homework1.service.impl;

import org.springframework.stereotype.Service;
import ru.otus.homework1.dao.CsvDao;
import ru.otus.homework1.model.Question;
import ru.otus.homework1.service.CsvService;

import java.util.ArrayList;
import java.util.List;

@Service
public class CsvServiceImpl implements CsvService {
    private CsvDao csvDao;

    public CsvServiceImpl(CsvDao csvDao){
        this.csvDao = csvDao;
    }

    public List<Question> getQuestionsList(){
        List<String[]> csvStrings = csvDao.readFile();
        List<Question> questionList = new ArrayList<>();
        csvStrings.forEach((strings -> {
            if (strings.length >= 2){
                questionList.add(new Question(strings[0],strings[1]));
            }
        }));
        return questionList;
    }
}
