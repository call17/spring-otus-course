package ru.otus.homework1;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import ru.otus.homework1.service.TestService;
import ru.otus.homework1.service.impl.TestServiceImpl;

import java.util.Locale;

@Configuration
@ComponentScan
public class Main {

    public static void main(String[] args) {
        Locale.setDefault(Locale.ENGLISH);
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(Main.class);
        TestService testService = context.getBean(TestServiceImpl.class);
        testService.executeTest();
    }
}
