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
}
