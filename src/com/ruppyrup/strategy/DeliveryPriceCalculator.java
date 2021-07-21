package com.ruppyrup.strategy;

import java.math.BigDecimal;

@FunctionalInterface
public interface DeliveryPriceCalculator {
    BigDecimal priceFor(Item item);
}
