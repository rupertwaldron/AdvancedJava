package com.ruppyrup.patterns.extensionObject;

public class PiecePart extends Part {

  public PiecePart(String partName, int partId) {
    super(partName, partId);
  }

  @Override
  public String getInfo() {
    return "Part -> " + partId + " : " + partName;
  }
}
