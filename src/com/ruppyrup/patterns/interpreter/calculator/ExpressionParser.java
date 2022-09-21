package com.ruppyrup.patterns.interpreter.calculator;

import java.util.Stack;
import org.junit.jupiter.api.Test;

public class ExpressionParser {
  Stack<Expression> stack=new Stack<>();

  public int parse(String str){
    String[] tokenList = str.split(" ");
    for (String symbol : tokenList) {
      if (!ParserUtil.isOperator(symbol)) {
        Expression numberExpression = new NumberExpression(symbol);
        stack.push(numberExpression);
        System.out.printf("Pushed to stack: %d%n", numberExpression.interpret());
      } else if (ParserUtil.isOperator(symbol)) {
        Expression firstExpression = stack.pop();
        Expression secondExpression = stack.pop();
        System.out.printf("Popped operands %d and %d%n",
            firstExpression.interpret(), secondExpression.interpret());
        Expression operator = ParserUtil.getExpressionObject(firstExpression, secondExpression, symbol);
        System.out.printf("Applying Operator: %s%n", operator);
        stack.push(operator);
      }
    }
    return stack.pop().interpret();
  }
}

class ExpressionParserTest {
  @Test
  public void testParse() throws Exception {
    String input="2 1 5 + *";
    ExpressionParser expressionParser = new ExpressionParser();
    int result = expressionParser.parse(input);
    System.out.println("Final result: " + result);
  }
}
