package com.ruppyrup.patterns.builder.lombok;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Builder;
import lombok.Singular;
import lombok.Value;
import lombok.experimental.Accessors;

import java.util.Arrays;
import java.util.List;
import java.util.function.Consumer;

@JsonAutoDetect(fieldVisibility = JsonAutoDetect.Visibility.ANY)
@JsonInclude(JsonInclude.Include.NON_NULL)
@Builder(setterPrefix = "with", builderClassName = "Builder", buildMethodName = "build0", toBuilder = true)
@Value
//@Jacksonized
@Accessors(fluent = true)
public class Address {
    @lombok.Builder.Default
    int houseNumber = 63;
    @lombok.Builder.Default
    String roadName = "Rances Lane";
    @lombok.Builder.Default
    List<Number> meterReadings = Arrays.asList(16.9, 120.9, 200.64);
    @lombok.Builder.Default
    County county;

    public static class Builder {
        County.Builder countyBuilder = County.builder();

        public Address build() {
            return this
                    .withCounty(countyBuilder.build())
                    .build0();

        }

        public Builder county(Consumer<County.Builder> countyAction) {
            countyAction.accept(countyBuilder);
            return this;
        }
    }
}
