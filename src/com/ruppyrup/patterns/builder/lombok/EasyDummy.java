package com.ruppyrup.patterns.builder.lombok;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.core.JsonProcessingException;
import lombok.Builder;
import lombok.NoArgsConstructor;
import lombok.Value;
import lombok.experimental.Accessors;
import lombok.extern.jackson.Jacksonized;

import java.util.function.Consumer;

@JsonAutoDetect(fieldVisibility = JsonAutoDetect.Visibility.ANY)
@JsonInclude(JsonInclude.Include.NON_NULL)
@Builder()
@Value
//@Jacksonized
@Accessors(fluent = true)
public class EasyDummy {
    @Builder.Default
    String name = "Rupert";
    @Builder.Default
    Integer age = 52;

    public String asJson() throws JsonProcessingException {
        return Mapper.mapper().writeValueAsString(this);
    }
}
