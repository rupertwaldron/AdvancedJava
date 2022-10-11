package com.ruppyrup.patterns.iterators.unclebob;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.Iterator;
import java.util.List;
import org.junit.jupiter.api.Test;

public class SquintTest {

  public static void main(String[] args) {
    printAll(take(25, squaresOf(Integers.all())));
  }

  private static void printAll(List<Integer> list) {
    list.forEach(System.out::println);
  }

  private static Iterator<Integer> squaresOf(Iterator<Integer> xs) {
    return new Mapper<Integer>().map(x -> x * x,xs);
  }

  private void assertNextValue(Iterator<Integer> list, int expectedValue) {
    assertTrue(list.hasNext());
    assertEquals(expectedValue, list.next().intValue());
  }

  private static List<Integer> take(int n, Iterator<Integer> xs) {
    return new Taker<Integer>().take(n, xs);
  }

  @Test
  public void integersAreConsecutive() {
    Iterator<Integer> ints = Integers.all();
    assertNextValue(ints, 1);
    assertNextValue(ints,2);
  }

  @Test
  public void mapCreatesNewIterator() {
    Iterator<Integer> squares = squaresOf(Integers.all());
    assertNextValue(squares, 1);
    assertNextValue(squares, 4);
  }
}
