package com.ruppyrup.patterns.builder.lombok;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Builder;
import lombok.Value;
import lombok.extern.jackson.Jacksonized;

import java.util.Random;

@JsonAutoDetect(fieldVisibility = JsonAutoDetect.Visibility.ANY)
@JsonInclude(JsonInclude.Include.NON_NULL)
@Builder(setterPrefix = "with", builderClassName = "Builder", toBuilder = true)
//@Jacksonized
@Value
public class County {
    @lombok.Builder.Default
    String countyName = "Berkshire";
    @lombok.Builder.Default
    Integer postCode = 100;
}
