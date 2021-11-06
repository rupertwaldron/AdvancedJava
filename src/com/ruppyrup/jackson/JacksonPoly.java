package com.ruppyrup.jackson;

import com.fasterxml.jackson.annotation.JsonSubTypes;
import com.fasterxml.jackson.annotation.JsonTypeInfo;

import java.io.Serializable;

public class JacksonPoly {
    public static void main(String[] args) {
//        PaymentMethod card = new Card();
    }
}

@JsonTypeInfo(
        use = JsonTypeInfo.Id.NAME,
        include = JsonTypeInfo.As.EXISTING_PROPERTY,
        property = "type",
        visible = true)
@JsonSubTypes({
        @JsonSubTypes.Type(value = Card.class, name = "CARD"),
        @JsonSubTypes.Type(value = PayPal.class, name = "PAYPAL"),
})
abstract class PaymentMethod implements Serializable {


    private String type;

    public abstract boolean save();
}
