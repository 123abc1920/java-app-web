package com.abc1920;

import com.abc1920.data.AppointmentRepository;
import com.abc1920.data.BirthdayRepository;
import com.abc1920.domain.model.factory.EventFactory;
import com.abc1920.presentation.ConsolePresentation;
import com.abc1920.usecases.facades.EventServiceDomain;
import com.abc1920.usecases.services.AppointmentService;
import com.abc1920.usecases.services.BirthdayService;

public class Main {
    public static void main(String[] args) {
        BirthdayRepository birthdayRepository = new BirthdayRepository();
        BirthdayService birthdayService = new BirthdayService(birthdayRepository);

        AppointmentRepository appointmentRepository = new AppointmentRepository();
        AppointmentService appointmentService = new AppointmentService(appointmentRepository);

        EventServiceDomain eventServiceDomain = new EventServiceDomain(birthdayService, appointmentService, new EventFactory());

        ConsolePresentation presentation = new ConsolePresentation(eventServiceDomain);
        presentation.start();
    }
}