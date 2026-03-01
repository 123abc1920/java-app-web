package com.abc1920.usecases.services;

import com.abc1920.domain.model.Month;
import com.abc1920.domain.model.event.Event;
import com.abc1920.domain.repository.IRepository;

public class UpdateEventService {
    private IRepository repository;

    public UpdateEventService(IRepository repository) {
        this.repository = repository;
    }

    public void updateName(int id, String newName) {
        Event event = repository.getById(id);
        if (event != null) {
            event.setName(newName);
        }
    }

    public void updateDescription(int id, String newDesc) {
        Event event = repository.getById(id);
        if (event != null) {
            event.setDescription(newDesc);
        }
    }

    public void updateDay(int id, int day) {
        Event event = repository.getById(id);
        if (event != null) {
            event.setDay(day);
        }
    }

    public void updateMonth(int id, Month newMonth) {
        Event event = repository.getById(id);
        if (event != null) {
            event.setMonth(newMonth);
        }
    }

    public void updateYear(int id, int year) {
        Event event = repository.getById(id);
        if (event != null) {
            event.setYear(year);
        }
    }

    public void updateRepeatative(int id, boolean repeatative) {
        Event event = repository.getById(id);
        if (event != null) {
            event.setRepeatable(repeatative);
        }
    }
}
