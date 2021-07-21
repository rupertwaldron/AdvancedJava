package com.ruppyrup.annotations;

public class AnnotationTester {
    public static void main(String[] args) throws JsonSerializeException, IllegalAccessException {
        Car car = new Car("Ford", "F150", "2018");
        Serializer serializer = new Serializer(car);
        String serialize = serializer.serialize(car);
        System.out.println(serialize);

    }
}
