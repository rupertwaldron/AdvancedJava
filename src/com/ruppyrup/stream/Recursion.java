package com.ruppyrup.stream;

import java.util.stream.Stream;

public class Recursion {

    public static void main(String[] args) {

        Stream.iterate(0, a -> {
            if (a == 0) return 0;
            else if (a == 1) return 1;
            return a - 1;
        })
                .limit(10)
                .forEach(System.out::println);


    }

}
