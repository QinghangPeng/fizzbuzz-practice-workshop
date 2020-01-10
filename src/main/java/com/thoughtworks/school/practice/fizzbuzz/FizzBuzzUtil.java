package com.thoughtworks.school.practice.fizzbuzz;

public class FizzBuzzUtil {

  public static String fizzbuzz(int number) {
    if (number % 3 == 0 && number % 5 == 0) {
      return "FizzBuzz";
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
