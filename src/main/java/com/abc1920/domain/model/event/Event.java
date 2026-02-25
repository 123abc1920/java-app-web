package com.abc1920.domain.model.event;

import com.abc1920.domain.model.Month;

public abstract class Event {
    private int day;
    private Month month;
    private int year;
    private String name;
    private String description;
    private boolean isRepeatable;

    public int getDay() {
        return this.day;
    }

    public void setDay(int day) {
        this.day = day;
    }

    public Month getMonth() {
        return this.month;
    }

    public void setMonth(Month month) {
        this.month = month;
    }

    public int getYear() {
        return this.year;
    }

    public void setYear(int year) {
        this.year = year;
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

    public Event(int day, Month month, int year, String name, String description, boolean isRepeatable) {
        this.day = day;
        this.month = month;
        this.year = year;
        this.name = name;
        this.description = description;
        this.isRepeatable = isRepeatable;
    }
}
