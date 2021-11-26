package com.ruppyrup.converters;

public class DoubleResult {
    private String request;
    private String response;

    public String getRequest() {
        return request;
    }

    public void setRequest(String request) {
        this.request = request;
    }

    public String getResponse() {
        return response;
    }

    public void setResponse(String response) {
        this.response = response;
    }

    @Override
    public String toString() {
        return "DoubleResult{" +
                "request='" + request + '\'' +
                ", response='" + response + '\'' +
                '}';
    }
}
