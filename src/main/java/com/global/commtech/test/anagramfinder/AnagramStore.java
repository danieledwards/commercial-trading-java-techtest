package com.global.commtech.test.anagramfinder;

import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@Component
public class AnagramStore {

    private HashMap<String, ArrayList<String>> store;

    public AnagramStore() {
        store = new HashMap<>();
    }

    public void clear() {
        store.clear();
    }

    public void put(String word) {
        String key = generateKey(word);
        ArrayList<String> strings = store.get(key);
        if (strings == null) {
            // create a new map entry
            strings = new ArrayList<>();
        }
        // do not add duplicates
        if (!strings.contains(word)) {
            strings.add(word);

        }
        store.put(key, strings);
    }


    public String generateKey(String word) {
        char charArray[] = word.toCharArray();
        Arrays.sort(charArray);
        return new String(charArray);
    }


    public void print() {
        Stream stream = store.keySet().stream();
        stream.forEach(key -> {
            String keyAsOutput = getValuesForKey((String) key);
            System.out.println(keyAsOutput);
        });
    }


    protected String getValuesForKey(String key) {
        ArrayList<String> values = store.get(key);

        if (values == null) {
            return "";
        }

        return values.stream().
                map(Object::toString).
                collect(Collectors.joining(",")).toString();
    }
}
