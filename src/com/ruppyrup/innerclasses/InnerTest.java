package com.ruppyrup.innerclasses;

public class InnerTest {
    int a;
    int b;
    final MessageRx receiver;

    public InnerTest(int a, int b, MessageRx receiver) {
        this.a = a;
        this.b = b;
        this.receiver = receiver;
    }

    private void doNothing() {
        // do nothing
    }

    public void sendIfValid() {
        if (new Validation().validateInputs()) {
            System.out.println("Valid result");
            receiver.receive(true);
        } else {
            System.out.println("Invallid result");
            receiver.receive(false);
        }
    }


    private class Validation {
        private boolean validateInputs() {
            doNothing();
            int validResult = 10;
            return a + b == validResult;
        }
    }

    public static void main(String[] args) {
        MessageRx receiver = new MessageRx();
        InnerTest innerTest = new InnerTest(4, 6, receiver);
        innerTest.sendIfValid();
    }
}
