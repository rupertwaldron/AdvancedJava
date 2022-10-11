package com.ruppyrup.patterns.iterators.unclebob;

public class Squares {

  public static void main(String[] args) {

    // Here the calculation is hidden within the loop
    for (int i = 1; i <= 25; i++) {
      System.out.println(i * i);
    }
  }

  // Hide the loop within the calculation
  // PrintAll(take(25, SquaresOf(Integers.all()));

}
