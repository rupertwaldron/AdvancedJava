package com.ruppyrup.annotations.jsonannotation;

import java.lang.reflect.Field;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public interface Jsonify {
    default String toJsonString() {
        var stringBuilder = new StringBuilder("{\n");

        Arrays.stream(this.getClass().getDeclaredFields())
                .filter(field -> field.isAnnotationPresent(JsonParam.class))
                .map(this::createStringFromFields)
                .forEach(stringBuilder::append);

        stringBuilder.deleteCharAt(stringBuilder.length() - 2).append("}");
        return stringBuilder.toString();
    }

    private String createStringFromFields(Field field) {
        field.setAccessible(true);
        var jsonData = "";
        String jsonParam = field.getAnnotation(JsonParam.class).value();

        if (field.getAnnotation(JsonParam.class).value().isEmpty()) {
            jsonParam = field.getName();
        }

        final List<String> interfaces = Arrays.stream(field.getType().getInterfaces())
                .map(Class::getSimpleName)
                .collect(Collectors.toList());

        try {
            if (field.getType().equals(String.class)) {
                jsonData = "\"" + field.get(this) + "\"";
            } else if (interfaces.contains("Jsonify")) {
                jsonData = ((Jsonify) field.get(this)).toJsonString();
            } else {
                jsonData = field.get(this).toString();
            }
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }
        return "\"" + jsonParam + "\" : " + jsonData + ",\n";
    }
}
