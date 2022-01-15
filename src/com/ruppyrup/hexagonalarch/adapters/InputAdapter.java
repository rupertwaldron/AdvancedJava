package com.ruppyrup.hexagonalarch.adapters;


import com.ruppyrup.hexagonalarch.core.Converter;

/**
 * This input Adapter must use core interfaces
 */
public class InputAdapter implements Adapter<Integer> {
  private final Converter converter;

  public InputAdapter(Converter converter) {
    this.converter = converter;
  }

  /**
   * @param inputNumber
   */
  @Override
  public void process(Integer inputNumber) {
    converter.convert(inputNumber);
  }

}
