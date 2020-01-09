package com.thoughtworks.school.practice.fizzbuzz;

public class FizzBuzzer {

  public String fizzbuzz(int number) {
    if (number % 3 == 0) {
      return "Fizz";
    }
    if (number % 5 == 0) {
      return "Buzz";
    }
    return String.valueOf(number);
  }
}
