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
}