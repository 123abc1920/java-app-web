package com.abc1920.domain.model.event;

import java.util.Date;

public class Appointment extends Event {
    public Appointment(int id, Date date, String name, String description, boolean isRepeatable) {
        super(id, date, name, description, isRepeatable);
    }
}
