package com.ruppyrup.reflection.myrulesengine.fizzbuzz;

import com.ruppyrup.reflection.myrulesengine.engine.RulesEngine;
import com.ruppyrup.reflection.myrulesengine.engine.Rule;
import com.ruppyrup.reflection.myrulesengine.engine.DefaultRulesEngine;
import java.util.function.Function;
import java.util.stream.IntStream;

public class TestRulesEngine {

  public static void main(String[] args) {
    Function<Integer, String> defaultAction = String::valueOf;

    RulesEngine<Integer, String> engine = new DefaultRulesEngine<>(defaultAction);
    Rule<Integer, String> buzzRule = new BuzzRule("Buzz");
    Rule<Integer, String> fizzRule = new FizzRule("Fizz");
    Rule<Integer, String> fizzBuzzRule = new FizzBuzzRule("FizzBuzz");

    engine.addRule(buzzRule);
    engine.addRule(fizzRule);
    engine.addRule(fizzBuzzRule);

    IntStream.rangeClosed(1, 100)
        .mapToObj(engine::fireUp)
        .forEach(System.out::println);
  }
}
