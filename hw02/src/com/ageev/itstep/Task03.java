package com.ageev.itstep;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Task03 {
    public static void main(String[] args) {
       Map<String, String> cityMap = new HashMap<>();
       List<String> rusCities = new ArrayList<>(Arrays.asList("Moscow", "Petersburg",  "Novgorod",  "Kaluga"));
       List<String> ukrCities = new ArrayList<>(Arrays.asList("Kiev ", "Donetsk",  "Odessa"));
       fillMap("Russia",rusCities,cityMap);
       fillMap("Ukraine", ukrCities,cityMap);

        System.out.println(findCountry(cityMap,"Odessa"));
        System.out.println(findCountry(cityMap,"Moscow"));
        System.out.println(findCountry(cityMap,"Novgorod"));

    }

    private static String findCountry(Map<String, String> cityMap, String cityName) {
       return cityMap.get(cityName);
    }

    public static void fillMap (String country, List<String> cites, Map<String, String> map){
        for(String city : cites){
            map.put(city,country);
        }
    }
}
