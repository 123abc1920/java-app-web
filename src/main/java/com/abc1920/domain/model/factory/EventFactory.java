package com.abc1920.domain.model.factory;

import com.abc1920.domain.model.event.Appointment;
import com.abc1920.domain.model.event.Birthday;
import com.abc1920.domain.model.event.Event;
import com.abc1920.dto.EventDTO;

public class EventFactory {
    private final IdFactory idFactory;

    public EventFactory(IdFactory idFactory) {
        this.idFactory = idFactory;
    }

    public Event createEvent(EventDTO eventDTO) {
        if (eventDTO.getIsBirthday()) {
            return new Birthday(this.idFactory.generateId(), eventDTO.getDate(), eventDTO.getName(), eventDTO.getDescription(), eventDTO.getIsRepeatable());
        } else {
            return new Appointment(this.idFactory.generateId(), eventDTO.getDate(), eventDTO.getName(), eventDTO.getDescription(), eventDTO.getIsRepeatable());
        }
    }
}
