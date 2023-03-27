package com.ruppyrup.patterns.proxy;

public class ProxyTest {
    public static void main(String[] args) {
        ExpensiveObject object = new ExpensiveObjectProxy();
        object.process();
        object.process();
        ExpensiveObject object2 = new ExpensiveObjectProxy();
        object2.process();
        object2.process();
    }
}
