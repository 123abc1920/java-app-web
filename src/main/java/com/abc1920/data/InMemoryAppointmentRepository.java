package com.abc1920.data;

import com.abc1920.domain.model.event.Appointment;
import com.abc1920.domain.model.event.Event;
import com.abc1920.domain.model.factory.IdFactory;
import com.abc1920.domain.repository.AppointmentRepository;
import com.abc1920.dto.EventDTO;

import java.util.ArrayList;
import java.util.HashMap;

public class InMemoryAppointmentRepository implements AppointmentRepository {
    private final HashMap<Integer, Appointment> events = new HashMap<>();
    private final IdFactory idFactory = new IdFactory();

    @Override
    public ArrayList<Appointment> getAll() {
        return new ArrayList<>(events.values());
    }

    @Override
    public Appointment getById(int id) {
        return events.get(id);
    }

    @Override
    public void add(Appointment item) {
        int id = idFactory.generateId();
        item.setId(id);
        events.put(id, item);
    }

    @Override
    public void delete(int id) {
        events.remove(id);
    }

    @Override
    public void update(EventDTO event) {

    }

    @Override
    public boolean exists(EventDTO event) {
        for (Event e : this.events.values()) {
            if (e.equals(event)) {
                return true;
            }
        }

        return false;
    }
}
