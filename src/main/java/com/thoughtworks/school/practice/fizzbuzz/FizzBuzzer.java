package com.thoughtworks.school.practice.fizzbuzz;

public class FizzBuzzer {

  public String fizzbuzz(int number) {
    if (number % 3 == 0) {
      return "Fizz";
    }
    return String.valueOf(number);
  }
}
