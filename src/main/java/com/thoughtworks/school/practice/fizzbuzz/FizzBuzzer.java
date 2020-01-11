package com.thoughtworks.school.practice.fizzbuzz;

import static java.util.Arrays.asList;

import java.util.List;
import java.util.function.Predicate;

public class FizzBuzzer {

  private static final String FIZZ = "Fizz";
  private static final String BUZZ = "Buzz";
  private static final String WHIZZ = "Whizz";

  private List<FizzBuzzRuler> rulers;

  public FizzBuzzer() {
    rulers = asList(
        new FizzBuzzRuler(
            digit -> isContains(digit, 7) || !isContains(digit, 5),
            digit -> isContains(digit, 3),
            FIZZ
        ),
        new FizzBuzzRuler(
            digit -> (isContains(digit, 7) || !isContains(digit, 5)) && !isContains(digit, 3),
            digit -> isMultipleOf(digit, 3),
            FIZZ
        ),
        new FizzBuzzRuler(
            digit -> !isContains(digit, 7) && (isContains(digit, 5) || !isContains(digit, 3)),
            digit -> isMultipleOf(digit, 5),
            BUZZ
        ),
        new FizzBuzzRuler(
            digit -> isContains(digit, 5) || !isContains(digit, 3),
            digit -> isMultipleOf(digit, 7),
            WHIZZ
        )
    );
  }

  private boolean isContains(Integer digit, Integer contained) {
    return digit.toString().contains(contained.toString());
  }

  public String fizzBuzz(int digit) {
    return rulers.stream()
        .filter(rule -> rule.enableCondition.test(digit))
        .filter(rule -> rule.ruleChecker.test(digit))
        .map(FizzBuzzRuler::getValue)
        .reduce((acc, next) -> acc + next)
        .orElseGet(() -> String.valueOf(digit));
  }

  private boolean isMultipleOf(int digit, int dividedBy) {
    return digit % dividedBy == 0;
  }

  private static class FizzBuzzRuler {

    Predicate<Integer> enableCondition;
    Predicate<Integer> ruleChecker;
    String value;

    public FizzBuzzRuler(Predicate<Integer> enableCondition, Predicate<Integer> ruleChecker, String value) {
      this.enableCondition = enableCondition;
      this.ruleChecker = ruleChecker;
      this.value = value;
    }

    public String getValue() {
      return value;
    }
  }
}
