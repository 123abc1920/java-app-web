package com.abc1920.usecases.services;

import com.abc1920.domain.model.Month;
import com.abc1920.domain.model.event.Event;
import com.abc1920.domain.model.factory.EventFactory;
import com.abc1920.domain.repository.IRepository;

public class AddEventService {
    private EventFactory eventFactory;
    private IRepository repository;

    public AddEventService(EventFactory eventFactory, IRepository repository) {
        this.eventFactory = eventFactory;
        this.repository = repository;
    }

    public void addEvent(boolean isBirthday, int day, Month month, int year, String name, String description, boolean isRepeatable) {
        Event event = eventFactory.createEvent(isBirthday, day, month, year, name, description, isRepeatable);
        repository.addEvent(event);
    }
}
