package ru.otus.homework1.service;

import ru.otus.homework1.model.Question;
import ru.otus.homework1.model.User;

import java.util.List;

public class TestService {
    private ConsoleService consoleService;
    private CsvService csvService;

    public TestService(ConsoleService consoleService, CsvService csvService){
        this.consoleService = consoleService;
        this.csvService = csvService;
    }

    public void collectTestResult(){
        User user = new User();
        user.setName(consoleService.getAnswer("Enter name"));
        user.setLastName(consoleService.getAnswer("Enter lastName"));

        List<Question> listQuestions = csvService.getAnswerList();
        listQuestions.forEach(question -> {
            question.setUserAnswer(consoleService.getAnswer(question.getQuestion()));
            question.setCorrect(question.getExpectedAnswer().equals(question.getUserAnswer()));
        });
        consoleService.print("Test result: " + "\n______________");
        consoleService.print(user);
        consoleService.print(listQuestions);
    }
}
