package com.ruppyrup.solid.DIP.spring.springhistory.service;

public class HelloWorldMessageProvider implements IMessageProvider {
    @Override
    public String getMessage() {
        return "Hello World!";
    }
}
