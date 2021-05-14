package com.thoughtworks.school.practice.fizzbuzz;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CountGameTest {

    private CountGame countGame = new CountGame();

    @Test
    void should_return_number_when_it_is_normal_number() {
        //give
        int number = 1;

        //when
        String result = countGame.fizzBuzz(number);

        //then
        assertEquals("1",result);
    }

    @Test
    void should_return_fizz_when_it_is_multiple_of_3() {
        //give
        int number = 3;

        //when
        String result = countGame.fizzBuzz(3);

        //then
        assertEquals("Fizz",result);
    }
}