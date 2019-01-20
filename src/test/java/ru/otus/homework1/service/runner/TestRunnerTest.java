package ru.otus.homework1.service.runner;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import ru.otus.homework1.service.TestService;

import static org.mockito.Mockito.verify;

@SpringBootTest
class TestRunnerTest {

    @MockBean
    private TestService testService;

    @Test
    void run() throws Exception {
        verify(testService).executeTest();
    }
}