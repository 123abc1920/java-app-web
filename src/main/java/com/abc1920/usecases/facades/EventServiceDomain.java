package com.abc1920.usecases.facades;

import com.abc1920.domain.model.event.Appointment;
import com.abc1920.domain.model.event.Birthday;
import com.abc1920.domain.model.event.Event;
import com.abc1920.domain.model.factory.EventFactory;
import com.abc1920.dto.EventDTO;
import com.abc1920.usecases.services.AppointmentService;
import com.abc1920.usecases.services.BirthdayService;

import java.util.HashMap;

public class EventServiceDomain {
    private final BirthdayService birthdayService;
    private final AppointmentService appointmentService;

    private final EventFactory eventFactory;

    public EventServiceDomain(BirthdayService birthdayService, AppointmentService appointmentService, EventFactory eventFactory) {
        this.birthdayService = birthdayService;
        this.appointmentService = appointmentService;

        this.eventFactory = eventFactory;
    }

    public HashMap<Integer, Event> getAllEvents() {
        HashMap<Integer, Birthday> birthdays = this.birthdayService.getAllBirthdays();
        HashMap<Integer, Appointment> appointments = this.appointmentService.getAllAppointments();

        HashMap<Integer, Event> result = new HashMap<>();
        for (Event e : birthdays.values()) {
            result.put(e.getId(), e);
        }
        for (Event e : appointments.values()) {
            result.put(e.getId(), e);
        }

        return result;
    }

    public boolean isBirthday(int id) {
        HashMap<Integer, Birthday> birthdays = this.birthdayService.getAllBirthdays();
        HashMap<Integer, Appointment> appointments = this.appointmentService.getAllAppointments();

        if (birthdays.containsKey(id)) {
            return true;
        }
        if (appointments.containsKey(id)) {
            return false;
        }
        return false;
    }

    public Event getByName(String name) {
        Event e = this.birthdayService.getByName(name);
        System.out.println(name);
        if (e != null) {
            return e;
        } else {
            e = this.appointmentService.getByName(name);
            return e;
        }
    }

    public void addEvent(EventDTO eventDTO) {
        Event event = eventFactory.createEvent(eventDTO);
        if (eventDTO.getIsBirthday()) {
            this.birthdayService.add((Birthday) event);
        } else {
            this.appointmentService.add((Appointment) event);
        }
    }

    public void deleteEvent(String name) {
        Event event = this.birthdayService.getByName(name);
        if (event != null) {
            this.birthdayService.delete(event.getId());
            return;
        }

        event = this.appointmentService.getByName(name);
        if (event != null) {
            this.appointmentService.delete(event.getId());
            return;
        }
    }

    public void update(EventDTO eventDTO) {
        if (eventDTO == null) {
            return;
        }

        if (isBirthday(eventDTO.getId())) {
            this.birthdayService.update(eventDTO);
        } else {
            this.appointmentService.update(eventDTO);
        }
    }
}
