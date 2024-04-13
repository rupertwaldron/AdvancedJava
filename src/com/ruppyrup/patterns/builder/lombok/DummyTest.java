package com.ruppyrup.patterns.builder.lombok;

import com.fasterxml.jackson.core.JsonProcessingException;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

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
                .address(add -> add.county(cnty -> {
                    cnty.withCountyName("Berkshire");
                    cnty.withPostCode(567);
                }))
                .build();

        assertEquals("Beauchamp", dummy.address().roadName());
        assertEquals("Berkshire", dummy.address().county().getCountyName());
    }

    @Test
    void checkCanBuildWithDefaultFields() throws JsonProcessingException {
        Dummy dummy = Dummy.builder().build();

        assertEquals("Rupert", dummy.name());
        assertEquals("Rances Lane", dummy.address().roadName());
        assertEquals("Berkshire", dummy.address().county().getCountyName());
    }

    @Test
    void useToBuilder() throws JsonProcessingException {
        Dummy dummy = Dummy.builder().build();

        Dummy.Builder defaultSetting = dummy.toBuilder();

        Dummy newDummy = defaultSetting.address(add -> add.county(cnty -> cnty.withPostCode(666))).build();

        assertEquals("Rupert", newDummy.name());
        assertEquals("Rances Lane", newDummy.address().roadName());
        assertEquals("Berkshire", newDummy.address().county().getCountyName());
        assertEquals(666, newDummy.address().county().getPostCode());
    }

    @Test
    void useToBuilderWithNormalMethods() throws JsonProcessingException {
        Dummy dummy = Dummy.builder().build();

        Dummy.Builder defaultSetting = dummy.toBuilder();

        Dummy newDummy = defaultSetting.withAddress(dummy.address().toBuilder().withCounty(dummy.address().county().toBuilder().withPostCode(666).build()).build()).build();

        assertEquals("Rupert", newDummy.name());
        assertEquals("Rances Lane", newDummy.address().roadName());
        assertEquals("Berkshire", newDummy.address().county().getCountyName());
        assertEquals(666, newDummy.address().county().getPostCode());
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