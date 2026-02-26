package com.abc1920.usecases.services;

import com.abc1920.domain.model.event.Event;
import com.abc1920.domain.repository.IRepository;

import java.util.List;

public class GetEventService {
    private IRepository repository;

    public GetEventService(IRepository repository) {
        this.repository = repository;
    }

    public List<Event> getAllServices() {
        return this.repository.getAll();
    }

    public int getId(String name) {
        int i = 0;
        for (Event e : repository.getAll()) {
            if (e.getName().equals(name)) {
                return i;
            }
            i++;
        }
        return -1;
    }
}
