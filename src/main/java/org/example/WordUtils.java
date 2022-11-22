package org.example;

import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;

public class WordUtils {
    public static String getShortestWord(List<String> words) {
        return Collections.min(words, Comparator.comparing(String::length));
    }

    public static HashMap<String, Integer> countEachWord(String text) {
        HashMap<String, Integer> map = new HashMap<>();
        for (String word : text.split("\\W")) {
          if(word.isEmpty())
              continue;
          if(map.containsKey(word))
              map.put(word, map.get(word) + 1);
          else
              map.put(word, 1);
        }
        return map;
    }
}