package com.abc1920.domain.model.event;

import java.util.Date;

public class Birthday extends Event {
    public Birthday(Date date, String name, String description, boolean isRepeatable) {
        super(date, name, description, isRepeatable);
    }
}
