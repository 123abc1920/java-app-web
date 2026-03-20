package com.abc1920.data;

import com.abc1920.domain.model.event.Appointment;
import com.abc1920.domain.repository.AppointmentRepository;
import com.abc1920.domain.repository.CRUDRepository;

import java.util.ArrayList;
import java.util.HashMap;

public class InMemoryAppointmentRepository implements AppointmentRepository {
    private final HashMap<Integer, Appointment> events = new HashMap<>();

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
        events.put(item.getId(), item);
    }

    @Override
    public void delete(int id) {
        events.remove(id);
    }

    @Override
    public boolean exists(int id) {
        return events.containsKey(id);
    }
}
