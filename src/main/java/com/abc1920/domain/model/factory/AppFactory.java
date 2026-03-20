package com.abc1920.domain.model.factory;

import com.abc1920.domain.repository.AppointmentRepository;
import com.abc1920.domain.repository.BirthdayRepository;
import com.abc1920.presentation.console.CommandChain;
import com.abc1920.presentation.console.ConsolePresentation;
import com.abc1920.usecases.facades.EventServiceDomain;
import com.abc1920.usecases.services.AppointmentService;
import com.abc1920.usecases.services.BirthdayService;

import java.util.Scanner;

public class AppFactory {
    private final Scanner scanner = new Scanner(System.in);

    public void create() {
        RepositoryFactory repositoryFactory = new RepositoryFactory();
        ServiceFactory serviceFactory = new ServiceFactory();
        CommandFactory commandFactory = new CommandFactory();
        PresentationFactory presentationFactory = new PresentationFactory();
        EventFactory eventFactory = new EventFactory(new IdFactory());

        BirthdayRepository birthdayRepository = repositoryFactory.createBirthdayRepository();
        BirthdayService birthdayService = serviceFactory.createBirthdayService(birthdayRepository);

        AppointmentRepository appointmentRepository = repositoryFactory.createAppointmentRepository();
        AppointmentService appointmentService = serviceFactory.createAppointmentService(appointmentRepository);

        EventServiceDomain eventServiceDomain = serviceFactory.createEventServiceDomain(appointmentService, birthdayService, eventFactory);

        CommandChain commandChain = commandFactory.createCommandChain(eventServiceDomain, scanner);

        ConsolePresentation presentation = presentationFactory.createConsolePresentation(commandChain);
        presentation.start();
    }
}
