package com.ruppyrup.converters;

public interface RRBiConverter<S, T, R> {

    R convert(S s, T t);
}
