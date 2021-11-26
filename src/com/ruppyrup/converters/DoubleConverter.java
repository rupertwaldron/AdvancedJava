package com.ruppyrup.converters;

public class DoubleConverter implements DualConverter<Request, Response, DoubleResult>{
    @Override
    public DoubleResult convert(Request request, Response response) {
        DoubleResult doubleResult = new DoubleResult();
        doubleResult.setRequest(request.getRequest());
        doubleResult.setResponse(response.getResponse());
        return doubleResult;
    }

    @Override
    public DoubleResult convert(Response response) {
       return convert(null, response);
    }

}
