package com.ruppyrup.hexagonalarch.adapters.input;

import com.ruppyrup.hexagonalarch.ports.input.ConvertIntToRomanFile;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

/**
 *  Uses interfaces closer to the core so control in correct
 */
public class FileInput {

  private final ConvertIntToRomanFile fileUserCase;

  public FileInput(ConvertIntToRomanFile fileUserCase) {
    this.fileUserCase = fileUserCase;
  }

  public void fetchFromfile() {
    File myObj = new File("src/com/ruppyrup/hexagonalarch/input.txt");
    try (Scanner scanner = new Scanner(myObj)){
      while (scanner.hasNextLine()) {
        String data = scanner.nextLine();
        System.out.println("Data read from file :: " + data);
        fileUserCase.convertIntToRoman(Integer.parseInt(data));
      }
    } catch (FileNotFoundException e) {
      System.out.println("An error occurred.");
      e.printStackTrace();
    }
  }
}
