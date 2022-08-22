package com.ruppyrup.patterns.strategy;

import java.math.BigDecimal;

@FunctionalInterface
public interface DeliveryPriceCalculator {
    BigDecimal priceFor(Item item);
}
