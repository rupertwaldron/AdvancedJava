package com.ruppyrup.optionals;

import java.util.function.Consumer;
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

    public static <T, P extends Exception> void safeConsumer(Consumer<T> consumer, T arg, Class<P> p) throws Exception {
        try {
            consumer.accept(arg);
        } catch (Exception exception) {
            if(p.isInstance(exception)) {
                System.out.println("Exception of type " + p.getName() + " caught");
            }
        }
    }

    static class TestException extends Exception {
        public TestException(String message) {
            super(message);
        }
    }
}
