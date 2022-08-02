package com.ruppyrup.hexagonalarch.usecases;

import com.ruppyrup.hexagonalarch.core.Converter;
import com.ruppyrup.hexagonalarch.ports.input.ConvertIntToRomanFile;
import com.ruppyrup.hexagonalarch.ports.output.WriteToFile;

public class ConvertInputFromFileUC implements ConvertIntToRomanFile {

  private final Converter converter;
  private final WriteToFile writeToFile;

  public ConvertInputFromFileUC(Converter converter, WriteToFile writeToFile) {
    this.converter = converter;
    this.writeToFile = writeToFile;
  }

  @Override
  public void convertIntToRoman(int number) {
    String roman = converter.convert(number);
    writeToFile.sendToFile(roman);
  }
}
