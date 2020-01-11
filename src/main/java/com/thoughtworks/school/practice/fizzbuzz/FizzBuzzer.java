package com.thoughtworks.school.practice.fizzbuzz;

import java.util.ArrayList;
import java.util.List;

public class FizzBuzzer {

  private static final String FIZZ = "Fizz";
  private static final String BUZZ = "Buzz";
  private static final String WHIZZ = "Whizz";

  public String fizzBuzz(int digit) {
    List<String> result = new ArrayList<>();
    String digitString = String.valueOf(digit);
    boolean contains3 = digitString.contains("3");
    boolean contains5 = digitString.contains("5");
    boolean contains7 = digitString.contains("7");
    boolean enableRulesOf3 = contains7 || !contains5;
    boolean enableDividedBy3 = enableRulesOf3 && !contains3;
    boolean enableDividedBy7 = contains5 || !contains3;
    boolean enableDividedBy5 = !contains7 && enableDividedBy7;
    if (enableRulesOf3 && contains3) {
      result.add(FIZZ);
    }
    if (enableDividedBy3 && isMultipleOf(digit, 3)) {
      result.add(FIZZ);
    }
    if (enableDividedBy5 && isMultipleOf(digit, 5)) {
      result.add(BUZZ);
    }
    if (enableDividedBy7 && isMultipleOf(digit, 7)) {
      result.add(WHIZZ);
    }
    return result.isEmpty() ? digitString : String.join("", result);
  }

  private boolean isMultipleOf(int digit, int dividedBy) {
    return digit % dividedBy == 0;
  }
}
