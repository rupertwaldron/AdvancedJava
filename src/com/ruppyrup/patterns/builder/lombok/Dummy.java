package com.ruppyrup.patterns.builder.lombok;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.core.JsonProcessingException;
import lombok.Builder;
import lombok.Singular;
import lombok.Value;
import lombok.experimental.Accessors;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.function.Consumer;

@JsonAutoDetect(fieldVisibility = JsonAutoDetect.Visibility.ANY)
@JsonInclude(JsonInclude.Include.NON_NULL)
@Builder(setterPrefix = "with", builderClassName = "Builder", buildMethodName = "build0", toBuilder = true)
@Value
//@Jacksonized
@Accessors(fluent = true)
public class Dummy {
    @lombok.Builder.Default
    String name = "Rupert";
    @lombok.Builder.Default
    Integer age = 52;
    @lombok.Builder.Default
    Address address = null;
    @lombok.Builder.Default
    List<Neighbour> neighbours = new ArrayList<>(Arrays.asList(Neighbour.builder().build()));

    public String asJson() throws JsonProcessingException {
        return Mapper.mapper().writeValueAsString(this);
    }

    public static class Builder {
        Address.Builder addressBuilder = Address.builder();

        public Dummy build() {
            return this
                    .withAddress(addressBuilder.build())
                    .build0();
        }

        public Builder address(Consumer<Address.Builder> addressAction) {
            addressAction.accept(addressBuilder);
            return this;
        }

        public Builder neighbour(Neighbour neighbour) {
            neighbours$value.add(neighbour);
            return this;
        }
    }
}
