package com.ruppyrup.patterns.builder.lambda;

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
                    builder.phoneNumber = "01189891963";
                    builder.sex = Patient.Sex.FEMALE;
                })
                .with(b -> b.address = AddressForMe.builderOf()
                        .with(a -> a.road = "rances lane")
                        .with(a -> a.houseNumber = 7)
                        .with(a -> a.town = "wokingham")
                        .build())
                .build();

        System.out.println(sam);

        AddressForMe address = AddressForMe.builderOf()
                .with(b -> b.houseNumber = 63)
                .with(b -> b.road = "beauchamp road")
                .build();

        System.out.println(address);
    }
}
