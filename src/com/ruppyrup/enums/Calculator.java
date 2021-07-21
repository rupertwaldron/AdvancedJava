package com.ruppyrup.enums;

import java.util.Arrays;
import java.util.Scanner;
import java.util.function.IntBinaryOperator;

public class Calculator {

    public static void main(String[] args) {

        SumInput input = new SumInput();

        Sum test = input.getInput();

        calc(test);

    }

    static void calc(Sum sum) {
        System.out.println(sum.calculation.calculate(sum.a, sum.b));
    }



}


enum Calculation {
    SUM(Integer::sum, "+"),
    SUB((a, b) -> a - b, "-"),
    MULTI((a, b) -> a * b, "*"),
    DIV((a, b) -> a / b, "/");

    IntBinaryOperator operator;
    String symbol;

    Calculation(IntBinaryOperator operator, String symbol) {
        this.operator = operator;
        this.symbol = symbol;
    }

    int calculate(int a, int b) {
        return operator.applyAsInt(a, b);
    }

}

class SumInput {

    Sum getInput() {
        Scanner in = new Scanner(System.in);
        String[] input = in.nextLine().trim().split(" ");
        int a = Integer.parseInt(input[0]);
        int b = Integer.parseInt(input[2]);
        String calc = input[1];
        return new Sum(a, b, getCalculation(calc));
    }

    private Calculation getCalculation(String sym) {
        return Arrays.stream(Calculation.values())
                .filter(calculation -> calculation.symbol.equals(sym))
                .findFirst()
                .orElseThrow();
    }

}

class Sum {
    int a;
    int b;
    Calculation calculation;

    public Sum(int a, int b, Calculation calculation) {
        this.a = a;
        this.b = b;
        this.calculation = calculation;
    }
}
