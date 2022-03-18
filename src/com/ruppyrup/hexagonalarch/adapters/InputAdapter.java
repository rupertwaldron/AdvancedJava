package com.ruppyrup.hexagonalarch.adapters;


import com.ruppyrup.hexagonalarch.core.Converter;

/**
 * This input Adapter must use core interfaces
 */
public class InputAdapter implements Adapter<Integer> {
  private final Converter converter;
  private final Adapter<String> adapter;

  public InputAdapter(Converter converter, Adapter<String> adapter) {
    this.converter = converter;
    this.adapter = adapter;
  }

  /**
   * @param inputNumber
   */
  @Override
  public void process(Integer inputNumber) {
    String convert = converter.convert(inputNumber);
    adapter.process(convert);
  }

}
