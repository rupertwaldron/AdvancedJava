package com.ruppyrup.patterns.builder.lombok;

import com.fasterxml.jackson.core.JsonProcessingException;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class DummyTest {
    @Test
    void checkCanBuild() throws JsonProcessingException {
        Dummy dummy = Dummy.builder()
                .withAge(28)
                .withName("Fred")
                .withAddress(Address.builder()
                        .withHouseNumber(13)
                        .withRoadName("Beauchamp Road")
                                .withCounty(County.builder().withCountyName("Hampshire").build())
                        .build())
                .build();

        System.out.println(dummy.asJson());

    }

    @Test
    void checkCanBuildWithAddressConsumer() throws JsonProcessingException {
        Dummy dummy = Dummy.builder()
                .withAge(28)
                .withName("Bob")
                .address(add -> add.withHouseNumber(55).withRoadName("Norries"))
                .address(add -> add.withRoadName("Beauchamp"))
                .build();

        assertEquals("Beauchamp", dummy.address().roadName);

    }

    @Test
    void canSerializeAndDeserialize() throws JsonProcessingException {
        Dummy dummy = Dummy.builder()
                .withAge(28)
                .withName("Bob")
                .address(add -> add.withHouseNumber(55).withRoadName("Norries"))
                .address(add -> add.withRoadName("Beauchamp"))
                .build();

        String serialized = dummy.asJson();

        System.out.println(dummy);

        Dummy deserialized = Mapper.mapper().readValue(serialized, Dummy.class);
        System.out.println(deserialized);
        assertEquals(serialized, deserialized.asJson());
    }

    @Test
    void checkSerializeAndDeserializeDummy() throws JsonProcessingException {
        Dummy dummy = Dummy.builder()
                .withAge(28)
                .withName(null)
                .withAddress(Address.builder()
                        .withHouseNumber(13)
                        .withRoadName("Beauchamp Road")
                        .withCounty(County.builder().withCountyName(null).build())
                        .build())
                .build();

        String serialized = dummy.asJson();
        System.out.println(serialized);


        Dummy deserialized = Mapper.mapper().readValue(serialized, Dummy.class);
        System.out.println(deserialized.asJson());

        assertEquals(serialized, deserialized.asJson());
    }

    @Test
    void canSerializeAndDeserializeEasyDummy() throws JsonProcessingException {
        EasyDummy easyDummy = EasyDummy.builder()
                .age(null)
                .name("Bob")
                .build();

        String serialied = easyDummy.asJson();
        System.out.println(serialied);

        EasyDummy deserialized = Mapper.mapper().readValue(serialied, EasyDummy.class);
        System.out.println(deserialized);

        assertEquals(serialied, deserialized.asJson());
    }
}