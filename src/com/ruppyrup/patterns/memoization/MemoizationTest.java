package com.ruppyrup.patterns.memoization;

import java.util.function.Function;
import java.util.function.UnaryOperator;
import lombok.Getter;

public class MemoizationTest {

  public static void main(String[] args) {
    UnaryOperator<Integer> f = MemoizationTest::longCalculation;
    Function<Integer, Integer> g = Memoizer.memoize(f);

    long startTime = System.currentTimeMillis();
    Integer result1 = g.apply(1);
    long time1 = System.currentTimeMillis() - startTime;
    startTime = System.currentTimeMillis();
    Integer result2 = g.apply(1);
    long time2 = System.currentTimeMillis() - startTime;
    System.out.println(result1);
    System.out.println(result2);
    System.out.println(time1);
    System.out.println(time2);

    System.out.println("******************************");

    Function<ColorUnit, Integer> colorfunc = MemoizationTest::calculateElementTime;
    Function<ColorUnit, Integer> colorMemeoizer = Memoizer.memoize(colorfunc);

    startTime = System.currentTimeMillis();
    Integer colorResult1 = colorMemeoizer.apply(new ColorUnit(20, Element.WATER));
    long colorTime1 = System.currentTimeMillis() - startTime;
    startTime = System.currentTimeMillis();
    Integer colorResult2 = colorMemeoizer.apply(new ColorUnit(20, Element.WATER));
    long colorTime2 = System.currentTimeMillis() - startTime;
    System.out.println(colorResult1);
    System.out.println(colorResult2);
    System.out.println(colorTime1);
    System.out.println(colorTime2);
  }

  static Integer longCalculation(Integer x) {
    try {
      Thread.sleep(1_000);
    } catch (InterruptedException ignored) {
    }
    return x * 2;
  }

  static Integer calculateElementTime(ColorUnit colourUnit) {
    try {
      Thread.sleep(1_000);
    } catch (InterruptedException e) {
      throw new RuntimeException(e);
    }

    Element element = colourUnit.getElement();
    return switch(element) {
      case AIR -> element.getValue() * colourUnit.getTime();
      case WATER -> 10 * element.getValue() * colourUnit.getTime();
      case EARTH -> 100 * element.getValue() * colourUnit.getTime();
      case FIRE -> 1000 * element.getValue() * colourUnit.getTime();
    };
  }

}

@Getter
class ColorUnit {
  private int time;
  private Element element;

  public ColorUnit(int i, Element element) {
    this.time = i;
    this.element = element;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }

    ColorUnit colorUnit = (ColorUnit) o;

    if (time != colorUnit.time) {
      return false;
    }
    return element == colorUnit.element;
  }

  @Override
  public int hashCode() {
    int result = time;
    result = 31 * result + (element != null ? element.hashCode() : 0);
    return result;
  }
}

@Getter
enum Element {
  AIR(1),
  WATER(2),
  EARTH(3),
  FIRE(4);

  private int value;

  Element(int i) {
    value = i;
  }


}
