package com.abc1920.domain.repository;

import com.abc1920.domain.model.event.Event;

import java.util.List;

public interface IRepository {
    List<Event> getAll();

    void addEvent(Event event);
}
