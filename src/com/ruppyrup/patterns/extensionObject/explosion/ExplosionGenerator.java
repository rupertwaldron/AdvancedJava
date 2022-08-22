package com.ruppyrup.patterns.extensionObject.explosion;

import com.ruppyrup.patterns.extensionObject.Part;
import com.ruppyrup.patterns.extensionObject.Product;
import com.ruppyrup.patterns.extensionObject.ProductCatalogue;

public class ExplosionGenerator {

  private final ProductCatalogue productCatalogue;

  public ExplosionGenerator(ProductCatalogue productCatalogue) {
    this.productCatalogue = productCatalogue;
  }

  public void runExtension() {
    for (Product product : productCatalogue.getCatalogue()) {
      for (Part part: product.getParts()) {
        ((PartExplosionExtension) part.getExtension("explosion")).generateExplosionReport();
      }
    }
  }
}
