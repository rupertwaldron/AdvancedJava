package com.ruppyrup.solid.DIP;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class AfterTest {


    @Test
    void transformInput() {
        StringBuilder outputBuilder = new StringBuilder();
        Output mockOutput = outputBuilder::append;
        Input mockInput = () -> "test";
        Transformer transformer = new UpperCaseTransformer();

        After after = new After(mockInput, mockOutput);

        after.transformInput(transformer);

        Assertions.assertEquals("TEST", outputBuilder.toString());
    }
}
