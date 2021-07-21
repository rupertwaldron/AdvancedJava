package com.ruppyrup.datastructures;

import java.lang.reflect.Field;
import java.util.HashMap;
import java.util.Map;
import java.util.stream.IntStream;

public class HashMapCapacity {
    public static void main(String[] args) throws Exception {
        Map<String, Integer> map = new HashMap<>(2);

        IntStream.rangeClosed(1, 10)
                .forEach(i -> {
                    map.put(i + "", i);
                    try {
                        System.out.println(i + " -> " + getMapCapacity(map));
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                });

    }

    private static int getMapCapacity(Map<?, ?> map) throws Exception{

        //get the table from map
        Field mapField = HashMap.class.getDeclaredField("table");

        // give access to the table
        mapField.setAccessible(true);

        //now get the table Object array from our list
        Object[] internalArray = (Object[])mapField.get(map);

        //Internal array length is the HashMap capacity!
        return internalArray.length;
    }
}
