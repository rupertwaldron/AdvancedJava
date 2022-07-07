package com.ruppyrup.builder.parsing;

public class StringReader {

  private Builder builder;
  private final String newline = System.getProperty("line.separator");

  public StringReader(Builder builder) {
    this.builder = builder;
  }

  public void parseText(String text) {
    String[] split = text.split(newline);

    builder.addHeader(split[0]);
    builder.addFooter(split[split.length - 1]);
    for (int i = 1; i < split.length - 1; i++) {
      builder.addText(split[i]);
      builder.addNewLine();
    }
    builder.createFile();
  }


  public static void main(String[] args) {

    String test = """
        My Holiday
        On holiday this year we went to Forest of Dean.
        The lodge had a hot tub.
        The End;
        """;

    Builder builder = new AsciiText("sample.txt");

    StringReader director = new StringReader(builder);

    director.parseText(test);

    builder = new HtmlBuilder("sample.html");
    director.setBuilder(builder);
    director.parseText(test);
  }

  public void setBuilder(Builder builder) {
    this.builder = builder;
  }
}
