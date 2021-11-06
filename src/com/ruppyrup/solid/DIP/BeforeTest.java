package com.ruppyrup.solid.DIP;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

/**
 * Can't test manually!! Can't manually input to keyboard or read output
 */
class BeforeTest {

    @Test
    void upperCaseTextTest() {
        Before before = new Before();

        before.showInputInUppercase();
    }

}
