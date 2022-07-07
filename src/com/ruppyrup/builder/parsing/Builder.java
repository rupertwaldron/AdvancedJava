package com.ruppyrup.builder.parsing;

public interface Builder {
  void addHeader(String header);
  void addNewLine();
  void addText(String text);
  void addFooter(String footer);
  void createFile();
}
