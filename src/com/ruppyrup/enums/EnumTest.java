package com.ruppyrup.enums;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.jayway.jsonpath.DocumentContext;
import com.jayway.jsonpath.JsonPath;

import java.util.Map;
import java.util.function.UnaryOperator;

public class EnumTest {

    public static void main(String[] args) throws JsonProcessingException {
        String json = """
{
    "name": "Rupert",
    "age": "48",
    "color": "orange",
    "address": {
        "street": "Rances Lane",
        "town": "wokingham"
    }
}
""";
        DocumentContext parse = JsonPath.parse(json);
        var read = parse.read("$.address.street");
        System.out.println(read);
        Map map = new ObjectMapper().readValue(json, Map.class);
        System.out.println(map);
        MetaData.valueOf("bob");
        System.out.println(MetaData.NAME.getValue(json));
        System.out.println(MetaData.STREET.getValue(json));
    }


}

enum MetaData {
    NAME("$.name"),
    AGE("$.age"),
    COLOR("$.color"),
    STREET("$.address.street"),
    TOWN("$.address.town");

    private final String s;

    MetaData(String s) {
        this.s = s;
    }

    public String getValue(String json) {
        return JsonPath.parse(json).read(s);
    }
}

enum MetaData2 {
    NAME(json -> JsonPath.parse(json).read("$.name")),
    AGE(json -> JsonPath.parse(json).read("$.age")),
    COLOR(json -> JsonPath.parse(json).read("$.color")),
    ADDRESS(json -> JsonPath.parse(json).read("$.address")),
    STREET(json -> JsonPath.parse(json).read("$.address.street")),
    TOWN(json -> JsonPath.parse(json).read("$.address.town"));

    private final UnaryOperator func;

    MetaData2(UnaryOperator func) {
        this.func = func;
    }

    public UnaryOperator getFunc() {
        return func;
    }
}
