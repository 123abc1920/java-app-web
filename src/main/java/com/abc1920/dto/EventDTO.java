package com.abc1920.dto;

import java.util.Date;

public class EventDTO {
    private int id;
    private String name;
    private String description;
    private Date date;
    private boolean isRepeatable;
    private boolean isBirthday;

    public EventDTO(boolean isBirthday, String name, String description, Date date, boolean isRepeatable) {
        this.name = name;
        this.date = date;
        this.description = description;
        this.isBirthday = isBirthday;
        this.isRepeatable = isRepeatable;
    }

    public EventDTO(int id, String name, String description, Date date, boolean isRepeatable) {
        this.name = name;
        this.date = date;
        this.description = description;
        this.id = id;
        this.isRepeatable = isRepeatable;
    }

    public EventDTO(int id, boolean isBirthday, String name, String description, Date date, boolean isRepeatable) {
        this.name = name;
        this.date = date;
        this.description = description;
        this.isBirthday = isBirthday;
        this.isRepeatable = isRepeatable;
        this.id = id;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public boolean getIsBirthday() {
        return this.isBirthday;
    }

    public void setIsBirthday(boolean birthday) {
        isBirthday = birthday;
    }

    public boolean getIsRepeatable() {
        return this.isRepeatable;
    }

    public void setIsRepeatable(boolean repeatable) {
        isRepeatable = repeatable;
    }
}
