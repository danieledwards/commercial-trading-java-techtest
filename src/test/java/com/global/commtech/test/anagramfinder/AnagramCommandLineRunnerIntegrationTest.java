package com.global.commtech.test.anagramfinder;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.system.CapturedOutput;
import org.springframework.boot.test.system.OutputCaptureExtension;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@SpringBootTest(args = {"src/test/resources/example1.txt"})
@ExtendWith(OutputCaptureExtension.class)
class AnagramCommandLineRunnerIntegrationTest {

    @Autowired
    AnagramCommandLineRunner anagramCommandLineRunner;

    @Test
    void getAnagrams(){

    }

    @Test
    void shouldFindAnagrams(final CapturedOutput capturedOutput) {
        assertThat(capturedOutput.getOut()).contains("abc,bac,cba");
        assertThat(capturedOutput.getOut()).contains("fun,unf");
        assertThat(capturedOutput.getOut()).contains("hello");
    }


}
