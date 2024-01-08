package com.global.commtech.test.anagramfinder;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

import java.io.BufferedReader;
import java.io.FileReader;

@Component
@AllArgsConstructor
public class AnagramFileMatcher {

    private AnagramStore anagramStore;

    public void processFile(String inputFileName) throws Exception {
        FileReader fileReader = new FileReader(inputFileName);
        BufferedReader bufferedReader = new BufferedReader((fileReader));

        int currentWordLength = -1;
        String word;
        while ((word = bufferedReader.readLine()) != null) {

            if (word.length() > currentWordLength) {
                anagramStore.print();
                anagramStore.clear();
                currentWordLength = word.length();
                System.out.println("Processing words of length: " + currentWordLength);
            }
            anagramStore.put(word);
        }
        anagramStore.print();
        anagramStore.clear();
    }

}
