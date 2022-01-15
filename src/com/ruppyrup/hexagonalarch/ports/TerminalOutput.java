package com.ruppyrup.hexagonalarch.ports;

/**
 *  Implements Output interface which is polymorhic so control is passed back up the hierarchy
 */
public class TerminalOutput implements Output {

  @Override
  public void send(String output) {
    System.out.println(output);
  }
}
