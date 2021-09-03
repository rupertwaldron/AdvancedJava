package com.ruppyrup.collectingparameters;


public class UserMetrics {
    int countAgeLessThan25;
    int countAge25To35;
    int countAgeOver35;
    int countIsPremiumSubscriber;
    private void ageLessThan25(User user) {
        if (user.getAge() < 25) countAgeLessThan25++;
    }
    private void age25To35(User user) {
        if (user.getAge() >= 25 && user.getAge() < 35) countAge25To35++;
    }
    private void age35Up(User user) {
        if (user.getAge() >= 35) countAgeOver35++;
    }
    private void isPremiumSubscriber(User user) {
        if (user.isPremiumSubscriber()) countIsPremiumSubscriber++;
    }
    public void display(Display d) {
        d.view(this);
    }
    public void collect(User user) {
        ageLessThan25(user);
        age25To35(user);
        age35Up(user);
        isPremiumSubscriber(user);
    }

    @Override
    public String toString() {
        return "UserMetrics{" +
                "countAgeLessThan25=" + countAgeLessThan25 +
                ", countAge25To35=" + countAge25To35 +
                ", countAgeOver35=" + countAgeOver35 +
                ", countIsPremiumSubscriber=" + countIsPremiumSubscriber +
                '}';
    }
}
