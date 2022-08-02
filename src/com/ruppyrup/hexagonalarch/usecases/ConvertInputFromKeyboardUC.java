package com.ruppyrup.hexagonalarch.usecases;

import com.ruppyrup.hexagonalarch.core.Converter;
import com.ruppyrup.hexagonalarch.ports.input.ConvertIntToRomanKeyboard;
import com.ruppyrup.hexagonalarch.ports.output.WriteToTerminal;

public class ConvertInputFromKeyboardUC implements ConvertIntToRomanKeyboard {

  private final Converter converter;
  private final WriteToTerminal writeToTerminal;

  public ConvertInputFromKeyboardUC(Converter converter, WriteToTerminal writeToTerminal) {
    this.converter = converter;
    this.writeToTerminal = writeToTerminal;
  }

  @Override
  public void convertIntToRoman(int number) {
    String roman = converter.convert(number);
    writeToTerminal.sendToTerminal(roman);
  }
}
