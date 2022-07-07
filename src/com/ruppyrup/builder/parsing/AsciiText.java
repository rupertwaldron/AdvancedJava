package com.ruppyrup.builder.parsing;

import java.io.FileWriter;

public class AsciiText implements Builder {

  private final String filename;

  private static final String NEW_LINE = "\n";
  private String body = "";
  private String header;
  private String footer;

  public AsciiText(String filename) {
    this.filename = filename;
  }

  @Override
  public void addHeader(String header) {
    this.header = header;
  }

  @Override
  public void addNewLine() {
    body += NEW_LINE;
  }

  @Override
  public void addText(String text) {
    body += text;
  }

  @Override
  public void addFooter(String footer) {
    this.footer = footer;
  }

  @Override
  public void createFile() {
    StringBuilder sb = new StringBuilder(header);
    sb.append(NEW_LINE);
    sb.append("--------------");
    sb.append(NEW_LINE);
    sb.append(NEW_LINE);
    sb.append(body);
    sb.append(NEW_LINE);
    sb.append("**************");
    sb.append(NEW_LINE);
    sb.append(footer);

    try (FileWriter file = new FileWriter(filename)) {
      file.write(sb.toString());
    } catch (Exception e) {
      System.out.println(e.getMessage());
    }
  }
}
