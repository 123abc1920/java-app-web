package com.abc1920.usecases.services;

import com.abc1920.domain.repository.IRepository;

public class DeleteEventService {
    private IRepository repository;

    public DeleteEventService(IRepository repository) {
        this.repository = repository;
    }

    public void deleteEvent(int id) {
        repository.deleteEvent(id);
    }
}
