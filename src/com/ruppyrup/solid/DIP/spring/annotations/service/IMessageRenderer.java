package com.ruppyrup.solid.DIP.spring.annotations.service;

public interface IMessageRenderer {
    void render();

    // setter used by spring for injection
    void setMessageProvider(IMessageProvider provider);

    IMessageProvider getMessageProvider();
}
