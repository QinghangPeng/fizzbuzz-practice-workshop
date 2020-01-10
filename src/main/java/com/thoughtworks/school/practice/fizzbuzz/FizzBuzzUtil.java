package com.thoughtworks.school.practice.fizzbuzz;

import java.util.ArrayList;
import java.util.List;

public class FizzBuzzUtil {

  private static final String FIZZ = "Fizz";
  private static final String BUZZ = "Buzz";
  private static final String WHIZZ = "Whizz";

  public static String fizzbuzz(int number) {
    List<String> result = new ArrayList<>();
    if (number % 3 == 0) {
      result.add(FIZZ);
    }
    if (number % 5 == 0) {
      result.add(BUZZ);
    }
    if (number % 7 == 0) {
      result.add(WHIZZ);
    }
    return result.isEmpty() ? String.valueOf(number) : String.join("", result);
  }
}
