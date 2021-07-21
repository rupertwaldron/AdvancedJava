package com.ruppyrup.annotations;

import java.lang.annotation.Annotation;

@SerializeMyAss
@RuppyRup(name = "Bob")
public class Car {

    @JsonField("manufacturer")
    private final String make;

    @JsonField
    private final String model;

    @JsonField("Year of manufacture")
    private final String year;

    public Car(String make, String model, String year) {
        this.make = make;
        this.model = model;
        this.year = year;
    }

    public void process() {
        var cl = this.getClass();
        var annotations = cl.getAnnotations();
        for (Annotation annotation : annotations) {
            if (annotation instanceof RuppyRup) {
                System.out.println(((RuppyRup) annotation).name() + " was here");
            }
        }
    }

    public String getMake() {
        return make;
    }

    public String getModel() {
        return model;
    }

    public String getYear() {
        return year;
    }

    @Override
    public String toString() {
        return year + " " + make + " " + model;
    }
}
