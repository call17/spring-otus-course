package ru.otus.homework1.service.runner;

import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
import ru.otus.homework1.service.TestService;

@Component
public class TestRunner implements CommandLineRunner {

    private TestService testService;

    public TestRunner(TestService testService){
        this.testService = testService;
    }

    @Override
    public void run(String... args) throws Exception {
        testService.executeTest();
    }
}
