package com.ruppyrup.converters;

public class ConverterTest {
    public static void main(String[] args) {
        Request request = new Request("rrRequest");
        Response response = new Response("rrResponse");
        DualConverter<Request, Response, DoubleResult> doubleConverter = new DoubleConverter();
        DoubleResult doubleResult = doubleConverter.convert(request, response);
        System.out.println(doubleResult);
        DoubleResult singleResult = doubleConverter.convert(response);
        System.out.println(singleResult);
    }
}
