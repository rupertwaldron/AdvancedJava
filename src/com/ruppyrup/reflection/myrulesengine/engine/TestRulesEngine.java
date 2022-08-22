package com.ruppyrup.reflection.myrulesengine.engine;

import com.ruppyrup.reflection.myrulesengine.rules.BuzzRule;
import com.ruppyrup.reflection.myrulesengine.rules.FizzBuzzRule;
import com.ruppyrup.reflection.myrulesengine.rules.FizzRule;
import java.util.stream.IntStream;

public class TestRulesEngine {

  public static void main(String[] args) {
    RulesEngine<Integer> engine = new RulesEngine<>();
    Rule<Integer> buzzRule = new BuzzRule("Buzz");
    Rule<Integer> fizzRule = new FizzRule("Fizz");
    Rule<Integer> fizzBuzzRule = new FizzBuzzRule("FizzBuzz");
    engine.addRule(buzzRule);
    engine.addRule(fizzRule);
    engine.addRule(fizzBuzzRule);
    IntStream.rangeClosed(1, 100).forEach(engine::fireUp);
  }

}
