package com.ruppyrup.patterns.builder.lombok;

import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;

public class Mapper {

    private static ObjectMapper instance;

    public static ObjectMapper mapper() {
        if (instance == null) {
            instance = new ObjectMapper();
            instance = instance.findAndRegisterModules()
                    .disable(SerializationFeature.WRITE_DATES_AS_TIMESTAMPS)
                    .disable(SerializationFeature.WRITE_DATES_WITH_ZONE_ID)
                    .disable(DeserializationFeature.ADJUST_DATES_TO_CONTEXT_TIME_ZONE)
                    .configure(SerializationFeature.FAIL_ON_EMPTY_BEANS, false);
        }
        return instance;
    }
}
