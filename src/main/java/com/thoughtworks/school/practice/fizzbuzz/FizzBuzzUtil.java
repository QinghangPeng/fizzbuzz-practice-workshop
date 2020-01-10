package com.thoughtworks.school.practice.fizzbuzz;

import static java.util.Arrays.asList;
import static java.util.Collections.singletonList;

import java.util.List;
import java.util.function.Predicate;

public class FizzBuzzUtil {

  private static final String FIZZ = "Fizz";
  private static final String BUZZ = "Buzz";
  private static final String WHIZZ = "Whizz";

  private static final Strategy MAP_3_TO_FIZZ = new Strategy(i -> i % 3 == 0, FIZZ);
  private static final Strategy MAP_5_TO_BUZZ = new Strategy(i -> i % 5 == 0, BUZZ);
  private static final Strategy MAP_7_TO_WHIZZ = new Strategy(i -> i % 7 == 0, WHIZZ);
  private static final Strategy CONTAINS_3_TO_FIZZ = new Strategy(i -> String.valueOf(i).contains("3"), FIZZ);

  private static final Predicate<Integer> CONTAINS_3 = i -> String.valueOf(i).contains("3");
  private static final Predicate<Integer> CONTAINS_5 = i -> String.valueOf(i).contains("5");
  private static final Predicate<Integer> CONTAINS_7_AND_3 = i -> {
    String intStr = String.valueOf(i);
    return intStr.contains("7") && CONTAINS_3.test(i);
  };
  private static final Predicate<Integer> CONTAINS_7_NOT_3 = i -> {
    String intStr = String.valueOf(i);
    return intStr.contains("7") && !CONTAINS_3.test(i);
  };

  public static String fizzbuzz(int number) {
    return buildStrategySelector().stream()
        .filter(mapper -> mapper.condition.test(number))
        .findFirst()
        .map(ConditionStrategyMapper::getStrategies)
        .orElse(asList(MAP_3_TO_FIZZ, MAP_5_TO_BUZZ, MAP_7_TO_WHIZZ))
        .stream()
        .filter(strategy -> strategy.rule.test(number))
        .map(Strategy::getValue)
        .reduce((acc, next) -> acc + next)
        .orElse(String.valueOf(number));
  }

  private static List<ConditionStrategyMapper> buildStrategySelector() {
    return asList(
        new ConditionStrategyMapper(
            CONTAINS_7_AND_3,
            singletonList(CONTAINS_3_TO_FIZZ)
        ),
        new ConditionStrategyMapper(
            CONTAINS_7_NOT_3,
            asList(MAP_3_TO_FIZZ, MAP_7_TO_WHIZZ)
        ),
        new ConditionStrategyMapper(
            CONTAINS_5,
            asList(MAP_5_TO_BUZZ, MAP_7_TO_WHIZZ)
        ),
        new ConditionStrategyMapper(
            CONTAINS_3,
            singletonList(CONTAINS_3_TO_FIZZ)
        ));
  }

  private static class ConditionStrategyMapper {

    Predicate<Integer> condition;
    List<Strategy> strategies;

    public ConditionStrategyMapper(Predicate<Integer> condition,
        List<Strategy> strategies) {
      this.condition = condition;
      this.strategies = strategies;
    }

    public List<Strategy> getStrategies() {
      return strategies;
    }
  }

  private static class Strategy {

    Predicate<Integer> rule;
    String value;

    public Strategy(Predicate<Integer> rule, String value) {
      this.rule = rule;
      this.value = value;
    }

    public String getValue() {
      return value;
    }
  }
}
