package com.ruppyrup.patterns.builder.lombok;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Builder;
import lombok.EqualsAndHashCode;
import lombok.Value;
import lombok.experimental.Accessors;
import lombok.extern.jackson.Jacksonized;

@JsonAutoDetect(fieldVisibility = JsonAutoDetect.Visibility.ANY)
@JsonInclude(JsonInclude.Include.NON_NULL)
@Builder(setterPrefix = "with", toBuilder = true)
@EqualsAndHashCode
@Accessors(fluent = true)
//@Jacksonized
public class Address {
    @Builder.Default
    int houseNumber = 63;
    @Builder.Default
    String roadName = "Rances Lane";
    @Builder.Default
    County county = County.builder().build();
}
