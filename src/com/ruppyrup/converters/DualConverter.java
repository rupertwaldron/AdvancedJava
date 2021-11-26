package com.ruppyrup.converters;

public interface DualConverter<S, T, R> extends RRBiConverter<S, T, R>, RRConverter<T, R> {
}
