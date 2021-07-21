package com.ruppyrup.annotations.jsonannotation;

public class TestAnnotation {
    public static void main(String[] args) {
        College college = new College("Hallam", "Sheffield", 2130);
        System.out.println(college.toJsonString());
        StudentDTO studentDTO = new StudentDTO("Ted", 19, "Physics", college);
        System.out.println(studentDTO.toJsonString());
    }
}
