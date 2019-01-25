package ru.otus.homework1.service.impl;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import ru.otus.homework1.configs.YamlProps;
import ru.otus.homework1.service.ConsoleService;
import ru.otus.homework1.service.CsvService;
import ru.otus.homework1.service.TestService;
import static org.mockito.ArgumentMatchers.*;
import static org.mockito.Mockito.*;


class TestServiceImplTest {

    private TestService testService;

    @BeforeEach
    public void initTest(){
        ConsoleService consoleService = mock(ConsoleService.class);
        CsvService csvService = mock(CsvService.class);
        YamlProps messageSource = mock(YamlProps.class);
        when(consoleService.getAnswer(any())).thenReturn("en");
        testService = new TestServiceImpl(consoleService, csvService, messageSource);
    }

    @Test
    void executeTest() {
        testService.executeTest();
    }
}