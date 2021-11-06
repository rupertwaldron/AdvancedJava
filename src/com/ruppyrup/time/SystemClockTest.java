package com.ruppyrup.time;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.time.LocalDateTime;


class SystemClockTest {

    StubClock clock = new StubClock();


    @Test
    void testSystemClock() {

        clock.setTo(LocalDateTime.now());
        clock.setToOneHourEarlier();
        TrainTimeTable timeTable = new TrainTimeTable(clock);
        final var timeToTrain = timeTable.getTimeToTrain(LocalDateTime.now());
        Assertions.assertEquals(3600, timeToTrain);


    }

}
