package com.abc1920.domain.model.factory;

import com.abc1920.data.InMemoryAppointmentRepository;
import com.abc1920.data.InMemoryBirthdayRepository;
import com.abc1920.domain.repository.AppointmentRepository;
import com.abc1920.domain.repository.BirthdayRepository;
import com.abc1920.usecases.facades.EventServiceDomain;
import com.abc1920.usecases.services.AppointmentService;
import com.abc1920.usecases.services.BirthdayService;

public class ServiceFactory {
    public BirthdayService createBirthdayService(BirthdayRepository birthdayRepository) {
        return new BirthdayService(birthdayRepository);
    }

    public AppointmentService createAppointmentService(AppointmentRepository appointmentRepository) {
        return new AppointmentService(appointmentRepository);
    }

    public EventServiceDomain createEventServiceDomain(AppointmentService appointmentService, BirthdayService birthdayService, EventFactory eventFactory) {
        return new EventServiceDomain(birthdayService, appointmentService, eventFactory);
    }
}
