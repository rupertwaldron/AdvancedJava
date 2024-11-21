package com.ruppyrup.patterns.builder.lombok;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Builder;
import lombok.Value;

@JsonAutoDetect(fieldVisibility = JsonAutoDetect.Visibility.ANY)
@JsonInclude(JsonInclude.Include.NON_NULL)
@Builder(setterPrefix = "with", builderClassName = "Builder", toBuilder = true)
//@Jacksonized
@Value
public class Neighbour {
    @lombok.Builder.Default
    String surName = "Carpenter";
    @lombok.Builder.Default
    Integer houseNumber = 65;

}
