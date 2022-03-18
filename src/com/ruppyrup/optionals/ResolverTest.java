package com.ruppyrup.optionals;

import java.util.function.Predicate;

public class ResolverTest {


    public static void main(String[] args) {

        Country1 newZealand = new Country1("NZ");
        Address1 address = new Address1(newZealand);
        Person1 person = new Person1("Ross", "98700987");
        person.setAddress(address);

        final var countryCode = DataResolver.resolve(() -> person.getAddress().getCountry().getCountryCode());

        if (person.getAddress().getCountry().getCountryCode().contains("NZ")) {
            System.out.println("Hello from New Zealand");
        }

        Predicate<String> pred = a -> person.getAddress().getCountry().getCountryCode().contains(a);

        if (DataResolver.isTrue(pred, "NZ")) {
            System.out.println(countryCode);
        }


        Country1 austrailia = new Country1("AU");
        Address1 address1 = new Address1(null);
        Person1 person1 = new Person1("Rup", "98700987");
        person1.setAddress(address1);

        final var countryCode1 = DataResolver.resolve(() -> person1.getAddress().getCountry().getCountryCode());

        System.out.println(countryCode1);

        if (DataResolver.isTrue(a -> person.getAddress().getCountry().getCountryCode().contains(a), "AU")) {
            System.out.println(countryCode);
        } else {
            System.out.println("Value is not available");
        }


    }



}

class Person1 {
    private String name;
    private String contactNo;
    private String profession;
    private Address1 address;

    public Person1(String name, String contactNo) {
        System.out.println("Invoked Person constructor");
        this.name = name;
        this.contactNo = contactNo;
    }

    public Address1 getAddress() {
        return address;
    }

    @Override
    public String toString() {
        return "Person{" +
                "name='" + name + '\'' +
                ", contactNo='" + contactNo + '\'' +
                ", profession='" + profession + '\'' +
                ", address=" + address +
                '}';
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getContactNo() {
        return contactNo;
    }

    public void setContactNo(String contactNo) {
        this.contactNo = contactNo;
    }

    public String getProfession() {
        return profession;
    }

    public void setProfession(String profession) {
        this.profession = profession;
    }

    public void setAddress(Address1 address) {
        this.address = address;
    }
}

class Address1 {

    private Country1 country;

    public Country1 getCountry() {
        return country;
    }

    public Address1(Country1 country) {
        this.country = country;
    }
}

class Country1 {

    private String countryCode;

    public Country1(String countryCode) {
        this.countryCode = countryCode;
    }

    public String getCountryCode() {
        return countryCode;
    }
}

class ThrowsStuff {
    private Short value;

    public Short getValue()  {
        return value;
    }

    public String getValueString(Short value) throws DataResolver.TestException {
        return String.valueOf(value);
    }
}
