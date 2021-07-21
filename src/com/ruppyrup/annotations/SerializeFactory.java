package com.ruppyrup.annotations;

public class SerializeFactory {
    public static Serialize getSerialize(String type) {
        return switch (type) {
            case "String" -> new StringySerializer();
            case "Json" -> new JsonSerializer();
            case "Bytes" -> new ByteSerializer();
            default -> null;
        };
    }
}
