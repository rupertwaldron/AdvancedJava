package com.ruppyrup.solid.DIP.spring.oldway.service;

public class HelloWorldMessageProvider implements IMessageProvider {
    @Override
    public String getMessage() {
        return "Hello World!";
    }
}
