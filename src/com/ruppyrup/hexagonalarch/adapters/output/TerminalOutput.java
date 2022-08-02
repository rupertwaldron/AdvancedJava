package com.ruppyrup.hexagonalarch.adapters.output;

import com.ruppyrup.hexagonalarch.ports.output.WriteToTerminal;

/**
 *  Implements Output interface which is polymorhic so control is passed back up the hierarchy
 */
public class TerminalOutput implements WriteToTerminal {

  @Override
  public void sendToTerminal(String output) {
    System.out.println("Roman value is :: " + output);
  }
}
