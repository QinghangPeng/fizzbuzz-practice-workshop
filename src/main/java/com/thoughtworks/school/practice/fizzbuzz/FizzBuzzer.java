package com.thoughtworks.school.practice.fizzbuzz;

public class FizzBuzzer {

  public String fizzbuzz(int number) {
    if (number % (3 * 5) == 0) {
      return "FizzBuzz";
    }
    if (number % (3 * 7) == 0) {
      return "FizzWhizz";
    }
    if (number % 3 == 0) {
      return "Fizz";
    }
    if (number % 5 == 0) {
      return "Buzz";
    }
    if (number % 7 == 0) {
      return "Whizz";
    }
    return String.valueOf(number);
  }
}
