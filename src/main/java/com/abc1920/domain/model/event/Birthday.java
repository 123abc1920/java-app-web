package com.abc1920.domain.model.event;

import com.abc1920.domain.model.Month;

public class Birthday extends Event {
    public Birthday(int day, Month month, int year, String name, String description, boolean isRepeatable) {
        super(day, month, year, name, description, isRepeatable);
    }

    public Birthday(int day, Month month, int year, String name, String description) {
        super(day, month, year, name, description, true);
    }
}
