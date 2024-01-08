package com.global.commtech.test.anagramfinder;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

class AnagramFileMatcherTest {


    private AnagramFileMatcher anagramFileMatcher;

    AnagramStore anagramStore = mock(AnagramStore.class);

    @BeforeEach
    public void before() {
        anagramFileMatcher = new AnagramFileMatcher(anagramStore);
    }


    @Test
    public void storeResetOnChangeOfWordLength() throws Exception{
        anagramFileMatcher.processFile("src/test/resources/example1.txt");

        verify(anagramStore, times(3)).print();
        verify(anagramStore, times(3)).clear();
    }

    @Test
    public void emptyFile() throws Exception{
        anagramFileMatcher.processFile("src/test/resources/emptyFile.txt");

        verify(anagramStore, times(1)).print();
        verify(anagramStore, times(1)).clear();
    }
}
