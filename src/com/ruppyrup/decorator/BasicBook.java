package com.ruppyrup.decorator;

public class BasicBook implements Book {
    @Override
    public String describe() {
        return "Book";
    }
}
