package com.ruppyrup.patterns.template;

public class MakeDrinks {
    public static void main(String[] args) {
        Coffee coffee = new Coffee();
        Tea tea = new Tea();
        coffee.makeDrink();
        tea.makeDrink();
    }
}
