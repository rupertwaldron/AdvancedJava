package com.ruppyrup.patterns.iterators;

import java.util.Iterator;
import java.util.function.Consumer;

public class WordInterator implements Iterable<Character> {

  private char[] chars;
  private int counter = 0;

  public WordInterator(String word) {
    this.chars = word.toCharArray();
  }

  @Override
  public Iterator<Character> iterator() {
    return new Iterator<>() {
      @Override
      public boolean hasNext() {
        return counter < chars.length;
      }

      @Override
      public Character next() {
        return chars[counter++];
      }
    };
  }

  @Override
  public void forEach(Consumer<? super Character> action) {
    Iterable.super.forEach(action);
  }

  public static void main(String[] args) {
    WordInterator wordInterator = new WordInterator("Monkey Bollocks");
    wordInterator.forEach(System.out::println);
    Iterator<Character> iterator = wordInterator.iterator();

    while (iterator.hasNext()) {
      System.out.print(iterator.next() + "*");
    }

  }

}
