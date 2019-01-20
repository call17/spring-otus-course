package ru.otus.homework1.service.impl;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.context.MessageSource;
import ru.otus.homework1.dao.CsvDao;
import ru.otus.homework1.service.ConsoleService;
import ru.otus.homework1.service.CsvService;
import ru.otus.homework1.service.TestService;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

class TestServiceImplTest {

    private TestService testService;

    @BeforeEach
    public void initTest(){
        ConsoleService consoleService = mock(ConsoleService.class);
        CsvService csvService = mock(CsvService.class);
        MessageSource messageSource = mock(MessageSource.class);

        testService = new TestServiceImpl(consoleService, csvService, messageSource);
    }

    @Test
    void executeTest() {
        testService.executeTest();
    }
}