package com.ageev.itstep;

import com.ageev.itstep.entity.Phone;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Task1 {
    public static void main(String[] args) {
        Phone phone1 = new Phone("Black", 100, 8.3);
        Phone phone2 = new Phone("White", 110, 8.1);
        Phone phone3 = new Phone("Yellow", 120, 7.2);
        Phone phone4 = new Phone("Black", 100, 8.7);
        Phone phone5 = new Phone("White", 90, 8.5);

        List<Phone> listPhone = new ArrayList<>();
        listPhone.add(phone1);
        listPhone.add(phone2);
        listPhone.add(phone3);
        listPhone.add(phone4);
        listPhone.add(phone5);

        List<Phone> blackPhone = getAllByColor(listPhone, "Black");
      //  System.out.println(blackPhone);
        getMaxPriceByColor(listPhone).entrySet().forEach(es -> System.out.println(es));

    }

    private static List<Phone> getAllByColor(List<Phone> listPhone, String color) {
        return listPhone.stream()
                .filter(phone -> phone.getColor().equals(color))
                .sorted(Comparator.comparingDouble(Phone::getPrice)
                        .thenComparing(Phone::getScreenSize))
                .collect(Collectors.toList());
    }

    private static Map<String, Optional<Phone>> getMaxPriceByColor(List<Phone> listPhone) {
        return listPhone.stream()
                .collect(Collectors
                        .groupingBy(Phone::getColor,Collectors.maxBy(Comparator.comparingDouble(Phone::getPrice))));

    }

}
