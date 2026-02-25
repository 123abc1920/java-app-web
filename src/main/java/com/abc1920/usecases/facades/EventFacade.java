package com.abc1920.usecases.facades;

import com.abc1920.domain.model.Month;
import com.abc1920.domain.model.event.Event;
import com.abc1920.usecases.services.AddEventService;
import com.abc1920.usecases.services.GetEventService;

import java.util.List;

public class EventFacade {
    private AddEventService addEventService;
    private GetEventService getEventService;

    public EventFacade(AddEventService addEventService, GetEventService getEventService) {
        this.addEventService = addEventService;
        this.getEventService = getEventService;
    }

    public List<Event> getAllEvents() {
        return getEventService.getAllServices();
    }

    public void addEvent(boolean isBirthday, int day, Month month, int year, String name, String description, boolean isRepeat) {
        this.addEventService.addEvent(isBirthday, day, month, year, name, description, isRepeat);
    }
}
