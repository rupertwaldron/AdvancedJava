package com.ruppyrup.converters;

public interface RRConverter<S, R> {

    R convert(S s);

}
