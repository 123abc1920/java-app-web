package com.abc1920.domain.model.event;

import java.util.Date;

public abstract class Event {
    private int id;
    private Date date;
    private String name;
    private String description;
    private boolean isRepeatable;

    public int getId() {
        return this.id;
    }

    public Date getDate() {
        return this.date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getDescription() {
        return this.description;
    }

    public void setRepeatable(boolean repeatable) {
        isRepeatable = repeatable;
    }

    public boolean isRepeatable() {
        return isRepeatable;
    }

    public Event(int id, Date date, String name, String description, boolean isRepeatable) {
        this.id = id;
        this.date = date;
        this.name = name;
        this.description = description;
        this.isRepeatable = isRepeatable;
    }
}
