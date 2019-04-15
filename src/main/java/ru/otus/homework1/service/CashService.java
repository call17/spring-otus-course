package ru.otus.homework1.service;

import java.util.List;

public interface CashService {
    void saveAnswer(String answer);

    List<String> getAnswers();
}
