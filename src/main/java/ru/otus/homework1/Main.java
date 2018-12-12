package ru.otus.homework1;

import org.springframework.context.support.ClassPathXmlApplicationContext;
import ru.otus.homework1.service.TestService;
import ru.otus.homework1.service.impl.TestServiceImpl;

public class Main {
    public static void main(String[] args) {
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("/homework1.xml");
        TestService testService = context.getBean(TestServiceImpl.class);
        testService.executeTest();
    }
}
