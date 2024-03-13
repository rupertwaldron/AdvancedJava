package com.ruppyrup.patterns.builder.lambda;

import java.util.function.Consumer;

public class AddressForMe {
    private String road;
    private int houseNumber;
    private String town;

    public AddressForMe(Builder builder) {
        this.houseNumber = builder.houseNumber;
        this.road = builder.road;
        this.town = builder.town;
    }

    public static Builder builderOf() {
        return new Builder();
    }

    @Override
    public String toString() {
        return "AddressForMe: road = " + road + " houseNumber = " + houseNumber + " town = " + town;
    }

    public static class Builder {
        public String road;
        public int houseNumber;
        public String town;

        public Builder with(Consumer<Builder> consumer) {
            consumer.accept(this);
            return this;
        }

        public AddressForMe build() {
            return new AddressForMe(this);
        }
    }
}
