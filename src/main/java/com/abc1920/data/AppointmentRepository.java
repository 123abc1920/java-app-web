package com.abc1920.data;

import com.abc1920.domain.model.event.Appointment;
import com.abc1920.domain.repository.CRUDRepository;

import java.util.HashMap;

public class AppointmentRepository implements CRUDRepository<Appointment> {
    private final HashMap<Integer, Appointment> events = new HashMap<>();

    @Override
    public HashMap<Integer, Appointment> getAll() {
        return events;
    }

    @Override
    public Appointment getById(int id) {
        return events.get(id);
    }

    @Override
    public void add(Appointment item) {
        events.put(item.getId(), item);
    }

    @Override
    public void delete(int id) {
        events.remove(id);
    }
}
