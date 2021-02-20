package com.ageev.itstep;

import java.util.Arrays;
import java.util.Comparator;
import java.util.EnumSet;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.TreeMap;
import java.util.function.Function;
import java.util.stream.Collectors;


import static java.util.stream.Collectors.counting;
import static java.util.stream.Collectors.groupingBy;

public class Task3 {
    public static void main(String[] args) {
        String str = "dddd dddd dddd dddd aaa bbb aaa bbb ccc";
        String[] splitStr = str.split(" ");
        LinkedHashMap<String, Long> sortedMap = getWordsCount(splitStr);
        System.out.println(sortedMap);
    }

    private static LinkedHashMap<String, Long> getWordsCount(String[] splitStr) {
        Map<String, Long> result = Arrays.stream(splitStr).
                collect(groupingBy(Function.identity(), counting()));
        return result.entrySet().stream()
                .sorted(Map.Entry.comparingByValue())
                .collect(Collectors
                        .toMap(Map.Entry::getKey,Map.Entry::getValue,(oldValue, newValue) -> newValue, LinkedHashMap::new));
    }
}
