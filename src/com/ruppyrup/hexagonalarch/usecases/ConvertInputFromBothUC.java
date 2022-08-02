package com.ruppyrup.hexagonalarch.usecases;

import com.ruppyrup.hexagonalarch.core.Converter;
import com.ruppyrup.hexagonalarch.ports.input.ConvertIntToRomanFile;
import com.ruppyrup.hexagonalarch.ports.input.ConvertIntToRomanKeyboard;
import com.ruppyrup.hexagonalarch.ports.output.WriteToFile;
import com.ruppyrup.hexagonalarch.ports.output.WriteToTerminal;

public class ConvertInputFromBothUC implements ConvertIntToRomanFile, ConvertIntToRomanKeyboard {

  private final Converter converter;
  private final WriteToFile writeToFile;
  private final WriteToTerminal writeToTerminal;

  public ConvertInputFromBothUC(Converter converter, WriteToFile writeToFile,
      WriteToTerminal writeToTerminal) {
    this.converter = converter;
    this.writeToFile = writeToFile;
    this.writeToTerminal = writeToTerminal;
  }

  @Override
  public void convertIntToRoman(int number) {
    String roman = converter.convert(number);
    writeToFile.sendToFile(roman);
    writeToTerminal.sendToTerminal(roman);
  }
}
