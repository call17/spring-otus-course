package ru.otus.homework1.service.runner;

import org.springframework.shell.standard.ShellComponent;
import org.springframework.shell.standard.ShellMethod;
import ru.otus.homework1.service.TestService;

@ShellComponent
public class TestCommands{

    private TestService testService;

    public TestCommands(TestService testService){
        this.testService = testService;
    }

    @ShellMethod
    public void test(String locale) throws Exception {
        testService.executeTest();
    }
}
