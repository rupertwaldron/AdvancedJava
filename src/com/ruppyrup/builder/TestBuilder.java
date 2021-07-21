package com.ruppyrup.builder;

public class TestBuilder {
    public static void main(String[] args) {
        Customer bob = Customer.builderOf("bob", "smith")
                .withAddress("7 Beachamp Road")
                .withAge(68)
                .withPhoneNumber("7049653")
                .withSex(Customer.Sex.MALE)
                .build();

        System.out.println(bob);

        Patient sam = Patient.builderOf("Sam", "Waldron")
                .with(builder -> {
                    builder.age = 33;
                    builder.address = "63 Rances Lane";
                    builder.phoneNumber = "01189891963";
                    builder.sex = Patient.Sex.FEMALE;
                }).build();

        System.out.println(sam);
    }
}
