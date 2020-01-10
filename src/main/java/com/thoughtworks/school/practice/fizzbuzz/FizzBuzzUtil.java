package com.thoughtworks.school.practice.fizzbuzz;

public class FizzBuzzUtil {

  private static final String FIZZ = "Fizz";
  private static final String BUZZ = "Buzz";
  private static final String WHIZZ = "Whizz";

  public static String fizzbuzz(int number) {

    AbstractFizzBuzzChain fizzbuzzChain = new Contains3(new DividedBy3(new DividedBy5(new DividedBy7(null))));

    String result = fizzbuzzChain.doChain(number);

    return result.length() == 0 ? String.valueOf(number) : result;

  }

  private static abstract class AbstractFizzBuzzChain {

    private String value;
    private AbstractFizzBuzzChain next;

    public AbstractFizzBuzzChain(String value, AbstractFizzBuzzChain next) {
      this.value = value;
      this.next = next;
    }

    public String doChain(int number) {
      String currentChainResult = isEnabled(number) && isSatisfyCondition(number) ? value : "";
      return currentChainResult + this.next(number);
    }

    abstract protected boolean isEnabled(int number);

    abstract protected boolean isSatisfyCondition(int number);

    private String next(int number) {
      return this.next == null ? "" : this.next.doChain(number);
    }
  }

  private static class Contains3 extends AbstractFizzBuzzChain {

    public Contains3(AbstractFizzBuzzChain next) {
      super(FIZZ, next);
    }

    @Override
    protected boolean isEnabled(int number) {
      String numberString = String.valueOf(number);
      return numberString.contains("7") || !numberString.contains("5");
    }

    @Override
    protected boolean isSatisfyCondition(int number) {
      return String.valueOf(number).contains("3");
    }
  }

  private static class DividedBy3 extends AbstractFizzBuzzChain {

    public DividedBy3(AbstractFizzBuzzChain next) {
      super(FIZZ, next);
    }

    @Override
    protected boolean isEnabled(int number) {
      String stringNumber = String.valueOf(number);
      return !stringNumber.contains("3") && (stringNumber.contains("7") || !stringNumber.contains("5"));
    }

    @Override
    protected boolean isSatisfyCondition(int number) {
      return number % 3 == 0;
    }
  }

  private static class DividedBy5 extends AbstractFizzBuzzChain {

    public DividedBy5(AbstractFizzBuzzChain next) {
      super(BUZZ, next);
    }

    @Override
    protected boolean isEnabled(int number) {
      String numberString = String.valueOf(number);
      return !numberString.contains("7") && (numberString.contains("5") || !numberString.contains("3"));
    }

    @Override
    protected boolean isSatisfyCondition(int number) {
      return number % 5 == 0;
    }
  }

  private static class DividedBy7 extends AbstractFizzBuzzChain {

    public DividedBy7(AbstractFizzBuzzChain next) {
      super(WHIZZ, next);
    }

    @Override
    protected boolean isEnabled(int number) {
      String numberString = String.valueOf(number);
      return !numberString.contains("3") || (numberString.contains("5") && !numberString.contains("7"));
    }

    @Override
    protected boolean isSatisfyCondition(int number) {
      return number % 7 == 0;
    }
  }


}
