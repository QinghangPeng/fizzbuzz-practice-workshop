package com.thoughtworks.school.practice.fizzbuzz;

import java.util.ArrayList;
import java.util.List;

public class FizzBuzzUtil {

  private static final String FIZZ = "Fizz";
  private static final String BUZZ = "Buzz";
  private static final String WHIZZ = "Whizz";

  public static String fizzbuzz(int number) {
    List<String> result = new ArrayList<>();
    String numberString = String.valueOf(number);
    boolean contains3 = numberString.contains("3");
    boolean contains5 = numberString.contains("5");
    boolean contains7 = numberString.contains("7");
    if (contains3 && (!contains5 || contains7)) {
      result.add(FIZZ);
    }
    if (number % 3 == 0 && !contains3 && (!contains5 || contains7)) {
      result.add(FIZZ);
    }
    if (number % 5 == 0 && !contains7 && (contains5 || !contains3)) {
      result.add(BUZZ);
    }
    if (number % 7 == 0 && (!contains7 && contains5 || !contains3)) {
      result.add(WHIZZ);
    }
    return result.isEmpty() ? numberString : String.join("", result);
  }
}
