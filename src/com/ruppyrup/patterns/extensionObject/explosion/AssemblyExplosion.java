package com.ruppyrup.patterns.extensionObject.explosion;

import com.ruppyrup.patterns.extensionObject.Part;

public class AssemblyExplosion implements PartExplosionExtension {

  private final Part part;

  public AssemblyExplosion(Part part) {
    this.part = part;
  }

  @Override
  public void generateExplosionReport() {
    System.out.println("\n--- Assembly Explosion-----\n");
    System.out.println(" - " + part.getInfo());
  }
}
