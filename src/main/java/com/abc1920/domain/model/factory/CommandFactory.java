package com.abc1920.domain.model.factory;

import com.abc1920.presentation.console.CommandChain;
import com.abc1920.presentation.console.command.AddAppointmentCommand;
import com.abc1920.presentation.console.command.ShowEventCommand;
import com.abc1920.presentation.console.command.AddBirthdayCommand;
import com.abc1920.presentation.console.command.DeleteEventCommand;
import com.abc1920.presentation.console.command.UpdateEventCommand;
import com.abc1920.presentation.console.command.ExitCommand;
import com.abc1920.presentation.console.command.Command;
import com.abc1920.usecases.facades.EventServiceDomain;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class CommandFactory {
    public CommandChain createCommandChain(EventServiceDomain eventServiceDomain, Scanner scanner) {
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
