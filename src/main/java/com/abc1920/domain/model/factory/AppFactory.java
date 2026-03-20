package com.abc1920.domain.model.factory;

import com.abc1920.data.AppointmentRepository;
import com.abc1920.data.BirthdayRepository;
import com.abc1920.presentation.console.CommandChain;
import com.abc1920.presentation.console.ConsolePresentation;
import com.abc1920.presentation.console.command.*;
import com.abc1920.usecases.facades.EventServiceDomain;
import com.abc1920.usecases.services.AppointmentService;
import com.abc1920.usecases.services.BirthdayService;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class AppFactory {
    private final Scanner scanner = new Scanner(System.in);

    public void create() {
        BirthdayRepository birthdayRepository = new BirthdayRepository();
        BirthdayService birthdayService = new BirthdayService(birthdayRepository);

        AppointmentRepository appointmentRepository = new AppointmentRepository();
        AppointmentService appointmentService = new AppointmentService(appointmentRepository);

        EventServiceDomain eventServiceDomain = new EventServiceDomain(birthdayService, appointmentService, new EventFactory(new IdFactory()));

        CommandChain commandChain = createCommandChain(eventServiceDomain, scanner);
        ConsolePresentation presentation = new ConsolePresentation(commandChain);
        presentation.start();
    }

    private static CommandChain createCommandChain(EventServiceDomain eventServiceDomain, Scanner scanner) {
        List<Command> commands = new ArrayList<>();

        commands.add(new ShowEventCommand(eventServiceDomain));
        commands.add(new AddBirthdayCommand(eventServiceDomain, scanner));
        commands.add(new AddAppointmentCommand(eventServiceDomain, scanner));
        commands.add(new DeleteEventCommand(eventServiceDomain, scanner));
        commands.add(new UpdateEventCommand(eventServiceDomain, scanner));
        commands.add(new ExitCommand());

        return new CommandChain(commands);
    }
}
