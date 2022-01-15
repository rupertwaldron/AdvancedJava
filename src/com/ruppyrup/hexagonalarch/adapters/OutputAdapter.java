package com.ruppyrup.hexagonalarch.adapters;

import com.ruppyrup.hexagonalarch.ports.Output;

/**
 *  Takes an output interface which is polymorphic so control is inverted
 */
public class OutputAdapter implements Adapter<String> {
  private final Output output;

  public OutputAdapter(Output output) {
    this.output = output;
  }

  @Override
  public void process(String outputString) {
    output.send(outputString);
  }
}
