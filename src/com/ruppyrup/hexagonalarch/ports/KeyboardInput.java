package com.ruppyrup.hexagonalarch.ports;

import com.ruppyrup.hexagonalarch.adapters.Adapter;

import java.util.Scanner;


/**
 *  Uses interfaces closer to the core so control in correct
 */
public class KeyboardInput implements Input {

  private final Adapter<Integer> inputAdapter;

  private Scanner scanner = new Scanner(System.in);

  public KeyboardInput(Adapter<Integer> inputAdapter) {
    this.inputAdapter = inputAdapter;
  }

  @Override
  public void fetch() {
    inputAdapter.process(scanner.nextInt());
  }
}
