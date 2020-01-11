package com.thoughtworks.school.practice.fizzbuzz;

public class FizzBuzzer {

  private static final String FIZZ = "Fizz";
  private static final String BUZZ = "Buzz";
  private static final String WHIZZ = "Whizz";

  public String fizzBuzz(int digit) {
    if (isMultipleOf(digit, 3)) {
      return FIZZ;
    }
    if (isMultipleOf(digit, 5)) {
      return BUZZ;
    }
    if (isMultipleOf(digit, 7)) {
      return WHIZZ;
    }
    return String.valueOf(digit);
  }

  private boolean isMultipleOf(int digit, int dividedBy) {
    return digit % dividedBy == 0;
  }
}
