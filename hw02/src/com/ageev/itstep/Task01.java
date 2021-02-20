package com.ageev.itstep;

//	Даны два списка чисел. Определить, сколько чисел содержится одновременно как в первом списке, так и во втором.

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Task01 {
    public static void main(String[] args) {
        List<Integer> list1 = new ArrayList<>(Arrays.asList(1,2,3));
        List<Integer> list2 = new ArrayList<>(Arrays.asList(1,2,3,4,5,6));
        System.out.println("Total digit in two list: " + digitsCount(list1,list2));
    }

    public static int digitsCount(List<Integer> list1, List<Integer> list2){
        List<Integer> tempList = new ArrayList<>(list1);
        tempList.retainAll(list2);
        return tempList.size();
    }
}
