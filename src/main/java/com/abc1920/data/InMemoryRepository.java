package com.abc1920.data;

import com.abc1920.domain.model.event.Event;
import com.abc1920.domain.repository.IRepository;

import java.util.ArrayList;
import java.util.List;

public class InMemoryRepository implements IRepository {
    private List<Event> events = new ArrayList<>();

    @Override
    public List<Event> getAll() {
        return events;
    }

    @Override
    public void addEvent(Event event) {
        events.add(event);
    }
}
