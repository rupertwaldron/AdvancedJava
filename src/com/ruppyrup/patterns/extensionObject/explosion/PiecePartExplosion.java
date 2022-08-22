package com.ruppyrup.patterns.extensionObject.explosion;

import com.ruppyrup.patterns.extensionObject.Part;

public class PiecePartExplosion implements PartExplosionExtension {

  private final Part part;

  public PiecePartExplosion(Part part) {
    this.part = part;
  }

  @Override
  public void generateExplosionReport() {
    System.out.println("\n---PiecePart Explosion-----\n");
    System.out.println(" - " + part.getInfo());
  }
}
