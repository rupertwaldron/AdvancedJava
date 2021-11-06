package com.ruppyrup.time;

import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;

public interface Clock {
    LocalDateTime now();
}

class SystemClock implements Clock {

    @Override
    public LocalDateTime now() {
        return LocalDateTime.now();
    }
}

class StubClock implements Clock {
    private LocalDateTime time;

    @Override
    public LocalDateTime now() {
        return time;
    }

    public void setTo(LocalDateTime time) {
        this.time = time;
    }

    public void setToOneHourEarlier() {
        time = time.minus(1L, ChronoUnit.HOURS);
    }
}
