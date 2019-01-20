package ru.otus.homework1.service.impl;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import ru.otus.homework1.dao.CsvDao;
import ru.otus.homework1.model.Question;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

class CsvServiceImplTest {

    private CsvServiceImpl csvService;
    private List<String[]> list = new ArrayList<>();

    @BeforeEach
    public void initTest(){
        CsvDao csvDao = mock(CsvDao.class);
        list.add(new String[]{"Вопрос","Ответ"});
        when(csvDao.readFile()).thenReturn(list);
        csvService = new CsvServiceImpl(csvDao);
    }

    @Test
    void getQuestionsList() {
        List<Question> questions = csvService.getQuestionsList();
        assertThat(questions)
                .isNotNull()
                .size()
                .isEqualTo(1);
        assertThat(questions.get(0).getQuestion())
                .isNotNull()
                .isEqualTo("Вопрос");
        assertThat(questions.get(0).getExpectedAnswer())
                .isNotNull()
                .isEqualTo("Ответ");
    }
}