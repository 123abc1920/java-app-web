package com.abc1920.usecases.facades;

import com.abc1920.domain.model.Month;
import com.abc1920.domain.model.event.Event;
import com.abc1920.domain.model.factory.EventFactory;
import com.abc1920.domain.repository.IRepository;
import com.abc1920.usecases.services.AddEventService;
import com.abc1920.usecases.services.DeleteEventService;
import com.abc1920.usecases.services.GetEventService;

import java.util.List;

public class EventFacade {
    private AddEventService addEventService;
    private GetEventService getEventService;
    private DeleteEventService deleteEventService;

    public EventFacade(IRepository repository, EventFactory eventFactory) {
        this.addEventService = new AddEventService(eventFactory, repository);
        this.getEventService = new GetEventService(repository);
        this.deleteEventService = new DeleteEventService(repository);
    }

    public List<Event> getAllEvents() {
        return getEventService.getAllServices();
    }

    public int getId(String name) {
        return getEventService.getId(name);
    }

    public void addEvent(boolean isBirthday, int day, Month month, int year, String name, String description, boolean isRepeat) {
        this.addEventService.addEvent(isBirthday, day, month, year, name, description, isRepeat);
    }

    public void deleteEvent(String name) {
        int id = getEventService.getId(name);

        if (id > -1) {
            deleteEventService.deleteEvent(id);
        }
    }
}
