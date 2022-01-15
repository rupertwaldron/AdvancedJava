package com.ruppyrup.hexagonalarch.ports;

import java.io.FileWriter;
import java.io.IOException;

/**
 *  Implements Output interface which is polymorhic so control is passed back up the hierarchy
 */
public class FileOutput implements Output {

  @Override
  public void send(String output) {
    try (FileWriter myWriter = new FileWriter("filename.txt");){
      myWriter.write(output);
      System.out.println("Successfully wrote to the file.");
    } catch (IOException e) {
      System.out.println("An error occurred.");
      e.printStackTrace();
    }
  }
}
