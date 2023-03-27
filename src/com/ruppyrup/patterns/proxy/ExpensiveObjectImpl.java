package com.ruppyrup.patterns.proxy;


public class ExpensiveObjectImpl implements ExpensiveObject {

    public ExpensiveObjectImpl() {
        heavyInitialConfiguration();
    }

    @Override
    public void process() {
        System.out.println(this + " is processing complete.");
    }

    private void heavyInitialConfiguration() {
        System.out.println("Loading initial configuration for ... " + this);
    }

}
