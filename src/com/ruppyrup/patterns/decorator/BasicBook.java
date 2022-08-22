package com.ruppyrup.patterns.decorator;

public class BasicBook implements Book {
    @Override
    public String describe() {
        return "Book";
    }
}
