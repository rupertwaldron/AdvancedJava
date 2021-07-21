package com.ruppyrup.annotations;

import java.util.Arrays;

import static java.util.Objects.requireNonNull;

public class Serializer implements Serialize {
    private Serialize serialize;
    Class<?> objectClass;

    public Serializer(Object object) {
        objectClass = requireNonNull(object).getClass();
        var annotations = objectClass.getAnnotations();

        Arrays.stream(annotations)
            .filter(a -> a instanceof SerializeMyAss)
            .findFirst()
            .ifPresent(annotation -> serialize = SerializeFactory.getSerialize(((SerializeMyAss) annotation).serializeMethod()));

        System.out.println(serialize);
    }

    @Override
    public String serialize(Object object) throws IllegalAccessException {
        return serialize.serialize(object);
    }


//        Map<String, String> jsonElements = new HashMap<>();
//
//        for (Field field : objectClass.getDeclaredFields()) {
//            field.setAccessible(true);
//            if (field.isAnnotationPresent(JsonField.class)) {
//                jsonElements.put(getSerializedKey(field), (String) field.get(object));
//            }
//        }
//        System.out.println(toJsonString(jsonElements));
//        return toJsonString(jsonElements);

}
