package com.ageev.itstep;

import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

//	Посчитать, сколько раз в строке встречается введенный символ.
public class Task01 {

    public static void main(String[] args) {
        String testString1 = "Аргентина манит негра";
        System.out.println(testString1 + " Is it palindrome: " + (isPalindrome(testString1) ? "Yes" : "No"));
    }

    public static boolean isPalindrome(String str) {
        return str.replaceAll(" ", "")
                .equalsIgnoreCase(new StringBuilder(str.replaceAll(" ", "")).reverse().toString());
    }

    public static String theLongestWord(String line) {
        String[] arr = line.split(" ");
        Arrays.sort(arr, Comparator.comparingInt(String::length).reversed());
        return arr[0];
    }

    public static int wordCount(String line) {
        return line.split(" ").length;
    }

    public static int symbolInLine(String line) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter symbol: ");
        String sym = sc.nextLine();
        Matcher matcher = Pattern.compile(sym).matcher(line);
        int result = 0;
        while (matcher.find()) {
            result++;
        }
        return result;
    }
}
