package com.thoughtworks.school.practice.fizzbuzz;

import static java.util.Arrays.asList;
import static java.util.Collections.singletonList;
import static java.util.stream.Collectors.joining;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;

public class FizzBuzzer {

  private static Strategy MULTIPLE_OF_3_TO_FIZZ = new Strategy(integer -> integer % 3 == 0, "Fizz");
  private static Strategy MULTIPLE_OF_5_TO_BUZZ = new Strategy(integer -> integer % 5 == 0, "Buzz");
  private static Strategy MULTIPLE_OF_7_TO_WHIZZ = new Strategy(integer -> integer % 7 == 0, "Whizz");
  private static Strategy CONTAINS_3_TO_FIZZ = new Strategy(integer -> String.valueOf(integer).contains("3"), "Fizz");
  private static Strategy CONTAINS_5_TO_BUZZ = new Strategy(integer -> String.valueOf(integer).contains("5"), "Buzz");
  private static Strategy CONTAINS_7_TO_WHIZZ = new Strategy(integer -> String.valueOf(integer).contains("7"), "Whizz");

  public String fizzbuzz(int number) {
    List<Strategy> strategies = buildStrategy(number);
    String result = pureFizzBuzz(number, strategies);
    return result.length() == 0 ? String.valueOf(number) : result;
  }

  private List<Strategy> buildStrategy(int number) {
    List<Strategy> strategies;
    if (CONTAINS_7_TO_WHIZZ.condition.test(number)) {
      strategies = asList(MULTIPLE_OF_3_TO_FIZZ, MULTIPLE_OF_7_TO_WHIZZ);
    } else if (CONTAINS_5_TO_BUZZ.condition.test(number)) {
      strategies = asList(MULTIPLE_OF_5_TO_BUZZ, MULTIPLE_OF_7_TO_WHIZZ);
    } else if (CONTAINS_3_TO_FIZZ.condition.test(number)) {
      strategies = singletonList(CONTAINS_3_TO_FIZZ);
    } else {
      strategies = baseStrategies();
    }
    return strategies;
  }

  private List<Strategy> baseStrategies() {
    List<Strategy> strategies = new ArrayList<>();
    strategies.add(MULTIPLE_OF_3_TO_FIZZ);
    strategies.add(MULTIPLE_OF_5_TO_BUZZ);
    strategies.add(MULTIPLE_OF_7_TO_WHIZZ);
    return strategies;
  }

  private String pureFizzBuzz(int number, List<Strategy> strategies) {
    return strategies.stream()
        .filter(strategy -> strategy.condition.test(number))
        .map(Strategy::getResult)
        .collect(joining());
  }

  private static class Strategy {

    Predicate<Integer> condition;
    String result;

    public Strategy(Predicate<Integer> condition, String result) {
      this.condition = condition;
      this.result = result;
    }

    public String getResult() {
      return result;
    }
  }

}
