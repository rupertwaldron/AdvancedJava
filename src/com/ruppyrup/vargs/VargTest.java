package com.ruppyrup.vargs;

import java.util.Arrays;

public class VargTest {

   private String[] vargone(String... args) {
       return args;
   }

    public static void main(String[] args) {
        VargTest test = new VargTest();
        String[] vargone = test.vargone("hello");
        Arrays.stream(vargone).forEach(System.out::println);
    }

}
