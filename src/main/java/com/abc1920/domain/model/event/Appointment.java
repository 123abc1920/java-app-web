package com.abc1920.domain.model.event;

import java.util.Date;

public class Appointment extends Event {
    public Appointment(Date date, String name, String description, boolean isRepeatable) {
        super(date, name, description, isRepeatable);

        this.isBirthday = false;
    }

    public Appointment(int id, Date date, String name, String description, boolean isRepeatable) {
        super(date, name, description, isRepeatable);
        this.setId(id);

        this.isBirthday = false;
    }
}
