package com.ruppyrup.builder.parsing;

import java.io.FileWriter;

public class HtmlBuilder implements Builder {

  private final String filename;

  private static final String NEW_LINE = "\n";

  private String body = "<BODY BGCOLOR=\"00FF55\">\n";
  private String footer = """
  </BODY>
  <footer>
  <p>""";

  private String header = """
      <HTML>
      <HEAD>
      <TITLE>
      """;

  public HtmlBuilder(String filename) {
    this.filename = filename;
  }

  @Override
  public void addHeader(String header) {
    this.header += header + NEW_LINE + "</TITLE>" + NEW_LINE + "</HEAD>" + NEW_LINE;
  }

  @Override
  public void addNewLine() {
    body += NEW_LINE;
  }

  @Override
  public void addText(String text) {
    body += "<p>" + text + "</p>";
  }

  @Override
  public void addFooter(String footer) {
    this.footer += footer + "</p>" + NEW_LINE + "</footer>" + NEW_LINE + "</HTML>";

  }

  @Override
  public void createFile() {
    String contents = header + body + footer;

    try (FileWriter file = new FileWriter(filename)) {
      file.write(contents);
    } catch (Exception e) {
      System.out.println(e.getMessage());
    }
  }
}
