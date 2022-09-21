package com.ruppyrup.solid.DIP.spring.loosecoupling.service;

public class HelloWorldMessageProvider implements IMessageProvider {

    @Override
    public String getMessage() {
        return "Hello World!";
    }
}
