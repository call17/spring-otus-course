package ru.otus.homework1.service.impl;

import org.springframework.stereotype.Service;
import ru.otus.homework1.configs.YamlProps;
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
    private YamlProps yamlProps;

    private static final String FIRSTNAME_CODE = "enter_firstname";
    private static final String LASTNAME_CODE = "enter_lastname";
    private static final String RESULT_CODE = "result_output";

    public TestServiceImpl(ConsoleService consoleService, CsvService csvService, YamlProps yamlProps){
        this.consoleService = consoleService;
        this.csvService = csvService;
        this.yamlProps = yamlProps;
    }

    public void executeTest(){
        String locale = consoleService.getAnswer("Your locale is ?");
        Locale.setDefault(Locale.forLanguageTag(locale));

        User user = new User();
        user.setName(consoleService.getAnswer(yamlProps.getMessage(FIRSTNAME_CODE)));
        user.setLastName(consoleService.getAnswer(yamlProps.getMessage(LASTNAME_CODE)));

        List<Question> listQuestions = csvService.getQuestionsList();
        listQuestions.forEach(question -> {
            question.setUserAnswer(consoleService.getAnswer(question.getQuestion()));
            question.setCorrect(question.getExpectedAnswer().equals(question.getUserAnswer()));
        });
        consoleService.print(yamlProps.getMessage(RESULT_CODE) + "\n______________");
        consoleService.print(user);
        consoleService.print(listQuestions);
    }
}
