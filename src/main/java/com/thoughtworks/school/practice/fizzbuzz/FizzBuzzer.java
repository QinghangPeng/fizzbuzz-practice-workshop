package com.thoughtworks.school.practice.fizzbuzz;

public class FizzBuzzer {

  private static final String FIZZ = "Fizz";

  public String fizzBuzz(int digit) {
    if (digit % 3 == 0) {
      return FIZZ;
    }
    return String.valueOf(digit);
  }
}
