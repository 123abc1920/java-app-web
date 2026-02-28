package com.abc1920.domain.repository;

import com.abc1920.domain.model.event.Event;

import java.util.List;

public interface IRepository {
    List<Event> getAll();

    Event getById(int id);

    void addEvent(Event event);

    void deleteEvent(int id);
}
