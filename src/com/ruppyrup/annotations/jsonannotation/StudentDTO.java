package com.ruppyrup.annotations.jsonannotation;

public class StudentDTO implements Jsonify {
    @JsonParam("studentId")
    private String name;

    @JsonParam
    private int age;

    @JsonParam("faculty")
    private String subject;

    @JsonParam
    private College college;

    public StudentDTO(String name, int age, String subject, College college) {
        this.name = name;
        this.age = age;
        this.subject = subject;
        this.college = college;
    }
}

