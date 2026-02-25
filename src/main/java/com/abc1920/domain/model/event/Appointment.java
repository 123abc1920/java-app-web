package com.abc1920.domain.model.event;

import com.abc1920.domain.model.Month;

public class Appointment extends Event {
    public Appointment(int day, Month month, int year, String name, String description, boolean isRepeatable) {
        super(day, month, year, name, description, isRepeatable);
    }

    public Appointment(int day, Month month, int year, String name, String description) {
        super(day, month, year, name, description, false);
    }
}
