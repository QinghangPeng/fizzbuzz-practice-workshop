package com.thoughtworks.school.practice.fizzbuzz;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

class FizzBuzzUtilTest {

  @Test
  void should_return_the_number_when_the_number_is_not_divided_by_3_5_7_and_does_not_contain_3_5_7() {
    String result = FizzBuzzUtil.fizzbuzz(1);

    assertEquals("1", result);
  }

  @Test
  void should_return_fizz_when_the_number_is_divided_by_3_and_does_not_contain_3_5_7() {
    String result = FizzBuzzUtil.fizzbuzz(6);

    assertEquals("Fizz", result);
  }

  @Test
  void should_return_buzz_when_the_number_is_divided_by_5_and_does_not_contain_3_5_7() {
    String result = FizzBuzzUtil.fizzbuzz(10);

    assertEquals("Buzz", result);
  }

  @Test
  void should_return_whizz_when_the_number_is_divided_by_7_and_does_not_contain_3_5_7() {
    String result = FizzBuzzUtil.fizzbuzz(14);

    assertEquals("Whizz", result);
  }

  @Test
  void should_return_fizz_buzz_when_the_number_is_divided_by_3_times_5_and_does_not_contain_3_5_7() {
    String result = FizzBuzzUtil.fizzbuzz(60);

    assertEquals("FizzBuzz", result);
  }

  @Test
  void should_return_fizz_whizz_when_the_number_is_divided_by_3_times_7_and_does_not_contain_3_5_7() {
    String result = FizzBuzzUtil.fizzbuzz(21);

    assertEquals("FizzWhizz", result);
  }

  @Test
  void should_return_buzz_whizz_when_the_number_is_divided_by_5_times_7_and_does_not_contain_3_5_7() {
    String result = FizzBuzzUtil.fizzbuzz(140);

    assertEquals("BuzzWhizz", result);
  }

  @Test
  void should_return_fizz_buzz_whizz_when_the_number_is_divided_by_3_times_5_times_7_and_does_not_contain_3_5_7() {
    String result = FizzBuzzUtil.fizzbuzz(210);

    assertEquals("FizzBuzzWhizz", result);
  }

  @Test
  void should_return_fizz_when_then_number_contains_3_despite_it_is_divided_by_5_or_7() {
    String result = FizzBuzzUtil.fizzbuzz(630);

    assertEquals("Fizz", result);
  }
}