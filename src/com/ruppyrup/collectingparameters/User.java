package com.ruppyrup.collectingparameters;

public class User {
    int age;
    boolean isPremiumSubscriber;

    public User(int age, boolean isPremiumSubscriber) {
        this.age = age;
        this.isPremiumSubscriber = isPremiumSubscriber;
    }

    public void reportMetrics(UserMetrics metrics) {
       metrics.collect(this);
    }

    public int getAge() {
        return age;
    }

    public boolean isPremiumSubscriber() {
        return isPremiumSubscriber;
    }
}


