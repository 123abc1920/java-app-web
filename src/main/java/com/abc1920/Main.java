package com.abc1920;

import com.abc1920.data.AppointmentRepository;
import com.abc1920.data.BirthdayRepository;
import com.abc1920.domain.model.factory.EventFactory;
import com.abc1920.presentation.console.CommandChain;
import com.abc1920.presentation.console.ConsolePresentation;
import com.abc1920.usecases.facades.EventServiceDomain;
import com.abc1920.usecases.services.AppointmentService;
import com.abc1920.usecases.services.BirthdayService;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        BirthdayRepository birthdayRepository = new BirthdayRepository();
        BirthdayService birthdayService = new BirthdayService(birthdayRepository);

        AppointmentRepository appointmentRepository = new AppointmentRepository();
        AppointmentService appointmentService = new AppointmentService(appointmentRepository);

        EventServiceDomain eventServiceDomain = new EventServiceDomain(birthdayService, appointmentService, new EventFactory());

        CommandChain commandChain = new CommandChain(eventServiceDomain, scanner);
        ConsolePresentation presentation = new ConsolePresentation(eventServiceDomain, commandChain);
        presentation.start();
    }
}