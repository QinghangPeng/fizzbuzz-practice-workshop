package com.thoughtworks.school.practice.fizzbuzz;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class FizzBuzzerTest {

  private FizzBuzzer fizzBuzzer = new FizzBuzzer();

  @Test
  void should_return_the_number_when_it_is_a_normal_number() {
    String result = fizzBuzzer.fizzbuzz(4);

    assertEquals("4", result);
  }

  @Test
  void should_return_fizz_when_it_is_multiple_of_3() {
    String result = fizzBuzzer.fizzbuzz(3);

    assertEquals("Fizz", result);
  }

  @Test
  void should_return_buzz_when_it_is_multiple_of_5() {
    String result = fizzBuzzer.fizzbuzz(5);

    assertEquals("Buzz", result);
  }

  @Test
  void should_return_whizz_when_it_is_multiple_of_7() {
    String result = fizzBuzzer.fizzbuzz(7);

    assertEquals("Whizz", result);
  }

  @Test
  void should_return_fizzbuzz_when_it_is_multiple_of_3_times_5() {
    String result = fizzBuzzer.fizzbuzz(15);

    assertEquals("FizzBuzz", result);
  }

  @Test
  void should_return_fizzwhizz_when_it_is_multiple_of_3_times_7() {
    String result = fizzBuzzer.fizzbuzz(21);

    assertEquals("FizzWhizz", result);
  }

  @Test
  void should_return_buzzwhizz_when_it_is_multiple_of_5_times_7() {
    String result = fizzBuzzer.fizzbuzz(35);

    assertEquals("BuzzWhizz", result);
  }
}