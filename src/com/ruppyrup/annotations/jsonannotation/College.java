package com.ruppyrup.annotations.jsonannotation;

public class College implements Jsonify {
    @JsonParam
    private String name;
    @JsonParam("city")
    private String town;
    @JsonParam
    private int numberOfStudents;

    public College(String name, String town, int numberOfStudents) {
        this.name = name;
        this.town = town;
        this.numberOfStudents = numberOfStudents;
    }
}
