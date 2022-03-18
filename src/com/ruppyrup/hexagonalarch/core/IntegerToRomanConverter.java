package com.ruppyrup.hexagonalarch.core;


import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.SortedMap;
import java.util.TreeMap;

/**
 * Control is inverted because use Adapter interface which is polymorphic
 * so any output adapter can be passed in
 */
public class IntegerToRomanConverter implements Converter {

  private SortedMap<Integer, String> romanNumerals;
  private List<Integer> sortedKeys;

  public IntegerToRomanConverter() {
    romanNumerals = new TreeMap<>(Map.of(
        1, "I", 5, "V", 10, "X", 50, "L",
        100, "C", 500, "D", 1000, "M"
    ));
    sortedKeys = new ArrayList<>(romanNumerals.keySet());
    Collections.reverse(sortedKeys);

  }

  @Override
  public String convert(int intToConvert) {
    throwIfNumberIsZeroOrNegative(intToConvert);

    String romanNumeralFound = romanNumerals.get(intToConvert);
    if (romanNumeralFound != null) {
      return romanNumeralFound;
    }

    StringBuilder result = new StringBuilder();

    int newIntoConvert = intToConvert;
    int i = 0;
    while (newIntoConvert > 0) {
      if (isNumberBiggerThanRoman(newIntoConvert, i)) {
        if (isNumberStartsWith4Or9(newIntoConvert, "4")) {
          newIntoConvert = modifiedResultFor4(result, newIntoConvert, i);
        } else if (isNumberStartsWith4Or9(newIntoConvert, "9")) {
          newIntoConvert = modifiedResultFor9(result, newIntoConvert, i);
        } else {
          result.append(romanNumerals.get(sortedKeys.get(i)));
          newIntoConvert -= sortedKeys.get(i);
        }
      } else {
        i++;
      }
    }
    return result.toString();
  }


  private boolean isNumberStartsWith4Or9(int newIntoConvert, String prefix) {
    return String.valueOf(newIntoConvert).startsWith(prefix);
  }

  private boolean isNumberBiggerThanRoman(int newIntoConvert, int i) {
    return newIntoConvert >= sortedKeys.get(i);
  }

  private void throwIfNumberIsZeroOrNegative(int intToConvert) {
    if (intToConvert <= 0) {
      throw new IllegalArgumentException("Argument must be equal to or greater than 1");
    }
  }

  private int modifiedResultFor4(StringBuilder result, int newIntoConvert, int i) {
    return appendedModifiedValues(result, newIntoConvert, i, 0);
  }

  private int modifiedResultFor9(StringBuilder result, int newIntoConvert, int i) {
    return appendedModifiedValues(result, newIntoConvert, i, 1);
  }

  private Integer appendedModifiedValues(StringBuilder result, int newIntoConvert, int i,
      int offset) {
    result.append(romanNumerals.get(sortedKeys.get(i + offset)))
        .append(romanNumerals.get(sortedKeys.get(i - 1)));
    String substring = String.valueOf(newIntoConvert).substring(1);
    return getIntegerValueOfString(substring);
  }

  private int getIntegerValueOfString(String substring) {
    if (substring.isEmpty()) {
      return 0;
    } else {
      return Integer.parseInt(substring);
    }
  }
}
