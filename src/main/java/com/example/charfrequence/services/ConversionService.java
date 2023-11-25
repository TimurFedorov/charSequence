package com.example.charfrequence.services;

import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.stream.Collectors;

@Service
public class ConversionService {

 public Map<String, Integer> getCharFrequency(String charSequence) {
        HashMap <String, Integer> dictionary = new HashMap<>();
        String [] charArray = charSequence.split("");

        for (int i = 0; i < charArray.length; i++) {
            String word = charArray[i];
            if (dictionary.containsKey(word)) {
                dictionary.put(word, dictionary.get(word) + 1);
            } else {
                dictionary.put(word, 1);
            }
        }

        Map<String, Integer> result = dictionary.entrySet()
                .stream()
                .sorted(Map.Entry.comparingByValue((o1, o2) -> o2 - o1))
                .collect(Collectors.toMap(
                        Map.Entry::getKey,
                        Map.Entry::getValue,
                        (oldValue, newValue) -> oldValue, LinkedHashMap::new));

        return result;
    }
}
