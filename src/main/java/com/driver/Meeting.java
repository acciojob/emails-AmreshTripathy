package com.driver;

import java.time.LocalTime;

public class Meeting {
    public LocalTime startTime;
    public LocalTime endTime;

    public Meeting(LocalTime startTime, LocalTime endTime) {
        this.startTime = startTime;
        this.endTime = endTime;
    }
}
