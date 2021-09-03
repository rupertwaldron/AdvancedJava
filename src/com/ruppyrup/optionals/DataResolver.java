package com.ruppyrup.optionals;

import java.util.function.Predicate;
import java.util.function.Supplier;

public class DataResolver {

    public static <T> T resolve(Supplier<T> supplier) {
        try {
            return supplier.get();
        } catch (NullPointerException npe){
            return null;
        }
    }

    public static <T> boolean isTrue(Predicate<T> predicate, T arg) {
        try {
            return predicate.test(arg);
        } catch (NullPointerException npe){
            return false;
        }
    }
}
