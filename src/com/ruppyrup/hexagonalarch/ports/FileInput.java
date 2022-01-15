package com.ruppyrup.hexagonalarch.ports;

import com.ruppyrup.hexagonalarch.adapters.Adapter;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

/**
 *  Uses interfaces closer to the core so control in correct
 */
public class FileInput implements Input {

  private final Adapter<Integer> inputAdapter;

  File inputFile = new File("input.txt");

  public FileInput(Adapter<Integer> inputAdapter) {
    this.inputAdapter = inputAdapter;
  }

  @Override
  public void fetch() {
    File myObj = new File("input.txt");
    try (Scanner scanner = new Scanner(myObj)){
      while (scanner.hasNextLine()) {
        String data = scanner.nextLine();
        System.out.println(data);
        inputAdapter.process(Integer.parseInt(data));
      }
    } catch (FileNotFoundException e) {
      System.out.println("An error occurred.");
      e.printStackTrace();
    }
  }
}
