package ru.otus.homework1.service.impl;

import org.springframework.context.MessageSource;
import org.springframework.stereotype.Service;
import ru.otus.homework1.model.Question;
import ru.otus.homework1.model.User;
import ru.otus.homework1.service.ConsoleService;
import ru.otus.homework1.service.CsvService;
import ru.otus.homework1.service.TestService;

import java.util.List;
import java.util.Locale;

@Service
public class TestServiceImpl implements TestService {
    private ConsoleService consoleService;
    private CsvService csvService;
    private MessageSource messageSource;

    public TestServiceImpl(ConsoleService consoleService, CsvService csvService, MessageSource messageSource){
        this.consoleService = consoleService;
        this.csvService = csvService;
        this.messageSource = messageSource;
    }

    public void executeTest(){
        User user = new User();
        user.setName(consoleService.getAnswer(messageSource.getMessage("enter_firstname",new String[]{}, Locale.getDefault())));
        user.setLastName(consoleService.getAnswer(messageSource.getMessage("enter_lastname",new String[]{}, Locale.getDefault())));

        List<Question> listQuestions = csvService.getQuestionsList();
        listQuestions.forEach(question -> {
            question.setUserAnswer(consoleService.getAnswer(question.getQuestion()));
            question.setCorrect(question.getExpectedAnswer().equals(question.getUserAnswer()));
        });
        consoleService.print("Test result: " + "\n______________");
        consoleService.print(user);
        consoleService.print(listQuestions);
    }
}
