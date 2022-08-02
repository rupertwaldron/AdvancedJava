package com.ruppyrup.hexagonalarch.adapters.input;

import com.ruppyrup.hexagonalarch.ports.input.ConvertIntToRomanKeyboard;
import java.util.Scanner;


/**
 *  Uses interfaces closer to the core so control in correct
 */
public class KeyboardInput {
  private final ConvertIntToRomanKeyboard keyboardUserCase;
  private final Scanner scanner = new Scanner(System.in);

  public KeyboardInput(ConvertIntToRomanKeyboard keyboardUserCase) {
    this.keyboardUserCase = keyboardUserCase;
  }

  public void fetchFromKeyboard() {
    keyboardUserCase.convertIntToRoman(scanner.nextInt());
  }
}
