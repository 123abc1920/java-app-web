package com.abc1920.presentation.console;

import com.abc1920.presentation.console.command.*;
import com.abc1920.presentation.console.command.triggers.CommandTriggers;
import com.abc1920.usecases.facades.EventServiceDomain;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class CommandChain {
    private List<Command> commands = new ArrayList<>();

    public CommandChain(EventServiceDomain eventServiceDomain, Scanner scanner) {
        commands.add(new ShowEventCommand(eventServiceDomain));
        commands.add(new AddBirthdayCommand(eventServiceDomain, scanner));
        commands.add(new AddAppointmentCommand(eventServiceDomain, scanner));
        commands.add(new DeleteEventCommand(eventServiceDomain, scanner));
        commands.add(new UpdateEventCommand(eventServiceDomain, scanner));
        commands.add(new ExitCommand());
    }

    public void process(String userInput) {
        for (Command cmd : commands) {
            if (cmd.supports(userInput)) {
                cmd.execute();
                return;
            }
        }
        System.out.println("Команда не найдена");
    }

    public String getAll() {
        String s = "";

        s += CommandTriggers.SHOW_EVENTS.toString() + "\n";
        s += CommandTriggers.ADD_BIRTHDAY.toString() + "\n";
        s += CommandTriggers.ADD_APPOINTMENT.toString() + "\n";
        s += CommandTriggers.DELETE_EVENT.toString() + "\n";
        s += CommandTriggers.UPDATE_EVENT.toString() + "\n";
        s += CommandTriggers.EXIT.toString();

        return s;
    }
}
