package ru.otus.homework1.service.impl;

import org.springframework.stereotype.Service;
import ru.otus.homework1.model.Question;
import ru.otus.homework1.model.User;
import ru.otus.homework1.service.TestService;

import java.util.List;

@Service
public class TestServiceImpl implements TestService {
    private ConsoleServiceImpl consoleService;
    private CsvServiceImpl csvService;

    public TestServiceImpl(ConsoleServiceImpl consoleService, CsvServiceImpl csvService){
        this.consoleService = consoleService;
        this.csvService = csvService;
    }

    public void executeTest(){
        User user = new User();
        user.setName(consoleService.getAnswer("Enter name"));
        user.setLastName(consoleService.getAnswer("Enter lastName"));

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
