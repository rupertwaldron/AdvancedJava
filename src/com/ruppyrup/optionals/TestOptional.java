package com.ruppyrup.optionals;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

public class TestOptional{
    private static Person rup = new Person("Rupert", "0716");

    public static void main(String[] args) {
        Person bob = new Person("Bob", "666");
        Person ted = null;

        Person me = Optional.ofNullable(ted).orElse(new Person("Mr Nobody", "000"));

        Person me2 = Optional.ofNullable(ted).orElseGet(() -> {
            System.out.println("hello");
            System.out.println(bob);
            return rup;
        });
        System.out.println(me2);

        String me3 = Optional.ofNullable(ted)
            .map(p -> p.getName().toUpperCase())
            .orElse("Unknown");

        System.out.println(me3);

        // transform with flatmap - need flatmap because getProfession returns an optional
        bob.setProfession("Journalist");
        var profession = Optional.ofNullable(ted)
            .flatMap(Person::getProfession)
            .orElse("Unknown Profession");

        System.out.println(profession);

        Country newZealand = new Country("NZ");
        Address address = new Address(newZealand);
        Person person = new Person("Ross", "98700987");
        person.setAddress(address);

        String countryCode =  Optional.of(person)
            .flatMap(Person::getAddress)
            .flatMap(Address::getCountry)
            .map(Country::getCountryCode) // need map as countrycode is never optional
            .orElse("UnKnown");

        System.out.println(countryCode);

        Person person1 = null;
        Person optionalPerson = Optional.ofNullable(person1)
            .or(() -> Optional.of(new Person("default", "9898"))).get();

        System.out.println(optionalPerson);

        Person person2 = null;
        Optional.ofNullable(person2)
            .ifPresentOrElse(
                p -> System.out.println(p.getName()),
                () -> System.out.println("Runnable")
            );

        Person person3 = new Person("Ross", "8765430091");
        List<String> name = Optional.ofNullable(person3)
            .stream()
            .map(p -> p.getName())
            .collect(Collectors.toList());

        System.out.println(name);
    }
}


class Person {
    private String name;
    private String contactNo;
    private String profession;
    private Address address;

    public Person(String name, String contactNo) {
        System.out.println("Invoked Person constructor");
        this.name = name;
        this.contactNo = contactNo;
    }

    public Optional<Address> getAddress() {
        return Optional.ofNullable(address);
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

    public Optional<String> getProfession() {
        return Optional.ofNullable(profession);
    }

    public void setProfession(String profession) {
        this.profession = profession;
    }

    public void setAddress(Address address) {
        this.address = address;
    }
}

class Address {

    private Country country;

    public Optional<Country> getCountry() {
        return Optional.ofNullable(country);
    }

    public Address(Country country) {
        this.country = country;
    }
}

class Country {

    private String countryCode;

    public Country(String countryCode) {
        this.countryCode = countryCode;
    }

    public String getCountryCode() {
        return countryCode;
    }
}