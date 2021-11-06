package com.ruppyrup.time;

import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;

public class TrainTimeTable {
    private final Clock time;

    public TrainTimeTable(Clock clock) {
        this.time = clock;
    }

    public Long getTimeToTrain(LocalDateTime trainTime) {
        return ChronoUnit.SECONDS.between(time.now(), trainTime);
    }
}
