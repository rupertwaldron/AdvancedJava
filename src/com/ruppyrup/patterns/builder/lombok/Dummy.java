package com.ruppyrup.patterns.builder.lombok;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.Builder;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.Value;
import lombok.experimental.Accessors;
import lombok.extern.jackson.Jacksonized;

import java.util.function.Consumer;

@JsonAutoDetect(fieldVisibility = JsonAutoDetect.Visibility.ANY)
@JsonInclude(JsonInclude.Include.NON_NULL)
@Builder(setterPrefix = "with", builderClassName = "Builder", buildMethodName = "build0")
@Value
//@Jacksonized
@Accessors(fluent = true)
public class Dummy {
    @lombok.Builder.Default
    String name = "Rupert";
    @lombok.Builder.Default
    Integer age = 52;
    Address address;

    public String asJson() throws JsonProcessingException {
        return Mapper.mapper().writeValueAsString(this);
    }

    public static class Builder {
        Address.AddressBuilder addressBuilder = Address.builder();

        public Dummy build() {
            return this
                    .withAddress(addressBuilder.build())
                    .build0();

        }

        public Builder address(Consumer<Address.AddressBuilder> addressAction) {
            addressAction.accept(addressBuilder);
            return this;
        }
    }
}
