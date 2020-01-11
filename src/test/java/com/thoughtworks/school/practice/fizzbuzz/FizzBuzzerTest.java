package com.thoughtworks.school.practice.fizzbuzz;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

class FizzBuzzerTest {

  private FizzBuzzer fizzBuzzer = new FizzBuzzer();

  @Test
  void should_return_the_number_when_it_does_not_match_any_rule() {
    assertEquals("2", fizzBuzzer.fizzBuzz(2));
  }

  @Test
  void should_return_fizz_when_it_is_multiple_of_3() {
    assertEquals("Fizz", fizzBuzzer.fizzBuzz(6));
  }

  @Test
  void should_return_buzz_when_it_is_multiple_of_5() {
    assertEquals("Buzz", fizzBuzzer.fizzBuzz(10));
  }

  @Test
  void should_return_whizz_when_it_is_multiple_of_7() {
    assertEquals("Whizz", fizzBuzzer.fizzBuzz(14));
  }

  @Test
  void should_return_fizz_buzz_when_it_is_multiple_of_3_and_5() {
    assertEquals("FizzBuzz", fizzBuzzer.fizzBuzz(60));
  }

  @Test
  void should_return_fizz_whizz_when_it_is_multiple_of_3_and_7() {
    assertEquals("FizzWhizz", fizzBuzzer.fizzBuzz(21));
  }

  @Test
  void should_return_buzz_whizz_when_it_is_multiple_of_5_and_7() {
    assertEquals("BuzzWhizz", fizzBuzzer.fizzBuzz(140));
  }

  @Test
  void should_return_fizz_buzz_whizz_when_it_is_multiple_of_3_and_5_and_7() {
    assertEquals("FizzBuzzWhizz", fizzBuzzer.fizzBuzz(210));
  }

  @Test
  void should_return_fizz_when_it_contains_3() {
    assertEquals("Fizz", fizzBuzzer.fizzBuzz(13));
  }
}