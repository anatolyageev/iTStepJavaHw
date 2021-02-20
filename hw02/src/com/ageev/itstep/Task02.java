package com.ageev.itstep;

import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;

public class Task02 {
    public static void main(String[] args) {
        String str = "aaa aaa aaa nnn mmm mmm iiiii iiiii iiiii iiiii";
        Map<Integer, String> map = new TreeMap<>();
        for (Map.Entry<String, Integer> entry : countWords(str).entrySet()) {
            map.put(entry.getValue(), entry.getKey());
        }
        System.out.println(map);
    }

    public static Map<String, Integer> countWords(String str) {
        Map<String, Integer> map = new HashMap<>();
        String[] strings = str.split("([,.])|\\s+");
        for (String word : strings) {
            if (word.length() == 0) {
                continue;
            }
            if (!map.containsKey(word)) {
                map.put(word, 1);
            } else {
                map.put(word, map.get(word) + 1);
            }
        }
        return map;
    }
}
