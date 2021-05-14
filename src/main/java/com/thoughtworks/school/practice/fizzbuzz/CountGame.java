package com.thoughtworks.school.practice.fizzbuzz;

import java.util.ArrayList;
import java.util.List;

public class CountGame {

    private static final String MULTIPLE_OF_3 = "Fizz";
    private static final String MULTIPLE_OF_5 = "Buzz";
    private static final String MULTIPLE_OF_7 = "Whizz";

    public String fizzBuzz(int number) {
        String realResult = String.valueOf(number);
        List<String> results = calculateResults(number);
        if (results.size() > 0) {
            realResult = String.join("", results);
        }
        return realResult;
    }

    private List<String> calculateResults(int number) {
        List<String> list = new ArrayList<>();
        if (number % 3 == 0) {
            list.add(MULTIPLE_OF_3);
        }
        if (number % 5 == 0) {
            list.add(MULTIPLE_OF_5);
        }
        if (number % 7 == 0) {
            list.add(MULTIPLE_OF_7);
        }
        return list;
    }
}
