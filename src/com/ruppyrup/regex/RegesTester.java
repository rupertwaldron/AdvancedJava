package com.ruppyrup.regex;

public class RegesTester {
    public static void main(String[] args) {
        String initial = "03/2030";
        System.out.println(initial.replaceFirst("/\\d{2}", ""));
    }
}
