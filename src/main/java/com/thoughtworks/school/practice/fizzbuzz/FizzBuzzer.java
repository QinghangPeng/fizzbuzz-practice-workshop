package com.thoughtworks.school.practice.fizzbuzz;

import java.util.ArrayList;
import java.util.List;

public class FizzBuzzer {

  public String fizzbuzz(int number) {
    if (String.valueOf(number).contains("3")) {
      return "Fizz";
    }
    List<String> resultCache = new ArrayList<>(3);
    if (number % 3 == 0) {
      resultCache.add("Fizz");
    }
    if (number % 5 == 0) {
      resultCache.add("Buzz");
    }
    if (number % 7 == 0) {
      resultCache.add("Whizz");
    }
    if (resultCache.isEmpty()) {
      return String.valueOf(number);
    } else {
      return String.join("", resultCache);
    }
  }
}
