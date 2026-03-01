package com.abc1920.usecases.facades;

import com.abc1920.domain.model.Month;
import com.abc1920.domain.model.event.Event;
import com.abc1920.domain.model.factory.EventFactory;
import com.abc1920.domain.repository.IRepository;
import com.abc1920.usecases.services.AddEventService;
import com.abc1920.usecases.services.DeleteEventService;
import com.abc1920.usecases.services.GetEventService;
import com.abc1920.usecases.services.UpdateEventService;

import java.util.List;

public class EventFacade {
    private AddEventService addEventService;
    private GetEventService getEventService;
    private DeleteEventService deleteEventService;
    private UpdateEventService updateEventService;

    public EventFacade(IRepository repository, EventFactory eventFactory) {
        this.addEventService = new AddEventService(eventFactory, repository);
        this.getEventService = new GetEventService(repository);
        this.deleteEventService = new DeleteEventService(repository);
        this.updateEventService = new UpdateEventService(repository);
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

    public void updateName(int id, String newName) {
        this.updateEventService.updateName(id, newName);
    }

    public void updateDescription(int id, String newDesc) {
        this.updateEventService.updateDescription(id, newDesc);
    }

    public void updateDay(int id, int day) {
        this.updateEventService.updateDay(id, day);
    }

    public void updateMonth(int id, Month newMonth) {
        this.updateEventService.updateMonth(id, newMonth);
    }

    public void updateYear(int id, int year) {
        this.updateEventService.updateYear(id, year);
    }

    public void updateRepeatative(int id, boolean repeatable){
        this.updateEventService.updateRepeatative(id, repeatable);
    }
}
