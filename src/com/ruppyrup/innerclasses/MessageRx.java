package com.ruppyrup.innerclasses;

public class MessageRx {
    boolean result;

    public void receive(boolean validation)  {
        result = validation;
        System.out.println("Receiver says validation result = " + result);
    }
}
