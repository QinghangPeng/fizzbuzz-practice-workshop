package com.thoughtworks.school.practice.fizzbuzz;

public class CountGame {


    public String fizzBuzz(int number) {
        if (number % 3 == 0) {
            return "Fizz";
        }
        return String.valueOf(number);
    }
}
