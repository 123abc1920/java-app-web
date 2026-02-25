package com.abc1920.domain.model.factory;

import com.abc1920.domain.model.Month;
import com.abc1920.domain.model.event.Appointment;
import com.abc1920.domain.model.event.Birthday;
import com.abc1920.domain.model.event.Event;

public class EventFactory {
    public Event createEvent(boolean isBirthday, int day, Month month, int year, String name, String description, boolean isRepeatable) {
        if (isBirthday) {
            return new Birthday(day, month, year, name, description, isRepeatable);
        } else {
            return new Appointment(day, month, year, name, description, isRepeatable);
        }
    }
}
