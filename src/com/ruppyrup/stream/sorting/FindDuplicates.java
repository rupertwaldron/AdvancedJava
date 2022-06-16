package com.ruppyrup.stream.sorting;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

public class FindDuplicates {

  public static void main(String[] args) {
    List<Integer> ints = Arrays.asList(2, 3, 3, 1, 1, 43, 7, 3, 2);

    Map<Integer, Long> collect = ints.stream()
        .collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));

    collect.forEach((k, v) -> System.out.println(k + " : " + v));
  }

}
