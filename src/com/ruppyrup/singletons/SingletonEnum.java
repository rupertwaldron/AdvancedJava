package com.ruppyrup.singletons;

import org.junit.jupiter.api.Assertions;

public enum SingletonEnum {
    INSTANCE(5);

    int value;

    SingletonEnum(int value) {
        this.value = value;
    }

    public int getValue() {
        return value;
    }

    public void setValue(int value) {
        this.value = value;
    }
}

class EnumDemo {
    public static void main(String[] args) {
        SingletonEnum singleton = SingletonEnum.INSTANCE;
        System.out.println(singleton.getValue());
        singleton.setValue(2);
        System.out.println(singleton.getValue());
        SingletonEnum singleton1 = SingletonEnum.INSTANCE;
        Assertions.assertEquals(singleton, singleton1);
    }
}