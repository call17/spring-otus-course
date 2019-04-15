package ru.otus.homework1.service.impl;

import org.springframework.stereotype.Component;
import ru.otus.homework1.service.CashService;

import java.util.ArrayList;
import java.util.List;

@Component
public class CashServiceImpl implements CashService {

    private static final ArrayList<String> answersCache = new ArrayList<>();

    @Override
    public void saveAnswer(String answer) {
        answersCache.add(answer);
    }

    @Override
    public List<String> getAnswers() {
        return answersCache;
    }
}
