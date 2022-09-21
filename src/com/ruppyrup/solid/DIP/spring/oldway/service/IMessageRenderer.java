package com.ruppyrup.solid.DIP.spring.oldway.service;

public interface IMessageRenderer {
    public void render();
    public void setMessageProvider(IMessageProvider provider);
}
