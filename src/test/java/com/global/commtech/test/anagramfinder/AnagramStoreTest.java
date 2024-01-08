package com.global.commtech.test.anagramfinder;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.*;

class AnagramStoreTest {

    private AnagramStore anagramStore;

    @BeforeEach
    void setup(){
        anagramStore = new AnagramStore();
    }


    @ParameterizedTest
    @MethodSource("testData")
    void put(List<String> input, String expected, String key) {
        for(String item : input ) {
            anagramStore.put(item);
        }
        assertEquals(expected, anagramStore.getValuesForKey(key));
    }

    static Stream<Arguments> testData() {
        return Stream.of(
                // input words, expected, key
                Arguments.of(Arrays.asList("abc"), "abc", "abc"),
                Arguments.of(Arrays.asList("bac"), "bac", "abc"),
                Arguments.of(Arrays.asList("abc", "bac", "cba"), "abc,bac,cba", "abc"),
                Arguments.of(Arrays.asList("bac", "acb", "cba"), "bac,acb,cba", "abc")
        );
    }

    @Test
    void ignoreDuplicates(){
        anagramStore.put("def");
        anagramStore.put("edf");
        anagramStore.put("def");

        assertEquals( "def,edf", anagramStore.getValuesForKey("def"));

    }

    @Test
    void keyNotFound(){
        assertEquals( "", anagramStore.getValuesForKey("abc"));
    }


    @Test
    void clear(){
        anagramStore.put("abc");
        assertEquals( "abc", anagramStore.getValuesForKey("abc"));

        anagramStore.clear();
        assertEquals( "", anagramStore.getValuesForKey("abc"));
    }
}
