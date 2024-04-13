package com.ruppyrup.patterns.builder.lombok;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Builder;
import lombok.EqualsAndHashCode;
import lombok.Value;
import lombok.experimental.Accessors;
import lombok.extern.jackson.Jacksonized;

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
    County county;

    public static class Builder {
        County.Builder countyBuilder = County.builder();

        public Address build() {
            return this
                    .withCounty(countyBuilder.build())
                    .build0();

        }

        public Address.Builder county(Consumer<County.Builder> countyAction) {
            countyAction.accept(countyBuilder);
            return this;
        }
    }
}
