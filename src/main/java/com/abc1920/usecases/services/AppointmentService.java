package com.abc1920.usecases.services;

import com.abc1920.data.AppointmentRepository;
import com.abc1920.domain.model.event.Appointment;
import com.abc1920.domain.model.event.Event;
import com.abc1920.dto.EventDTO;

import java.util.ArrayList;

public class AppointmentService {
    private final AppointmentRepository appointmentRepository;

    public AppointmentService(AppointmentRepository appointmentRepository) {
        this.appointmentRepository = appointmentRepository;
    }

    public Appointment get(int id) {
        return this.appointmentRepository.getById(id);
    }

    public Appointment getByName(String name) {
        for (Appointment a : appointmentRepository.getAll()) {
            if (name.equals(a.getName())) {
                return a;
            }
        }
        return null;
    }

    public ArrayList<Appointment> getAllAppointments() {
        return this.appointmentRepository.getAll();
    }

    public int getId(String name) {
        int i = 0;
        for (Event e : this.appointmentRepository.getAll()) {
            if (e.getName().equals(name)) {
                return i;
            }
            i++;
        }
        return -1;
    }

    public void add(Appointment item) {
        this.appointmentRepository.add(item);
    }

    public void delete(int id) {
        this.appointmentRepository.delete(id);
    }

    public void update(EventDTO eventDTO) {
        Appointment event = this.appointmentRepository.getById(eventDTO.getId());
        event.setDate(eventDTO.getDate());
        event.setDescription(eventDTO.getDescription());
        event.setName(eventDTO.getName());
        event.setRepeatable(eventDTO.getIsRepeatable());
    }

    public boolean containsId(int id) {
        return this.appointmentRepository.exists(id);
    }
}
