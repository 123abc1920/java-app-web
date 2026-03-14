package com.abc1920.presentation.console.command;

import com.abc1920.presentation.console.command.triggers.CommandTriggers;
import com.abc1920.usecases.facades.EventServiceDomain;

import java.util.Scanner;

public class DeleteEventCommand implements Command {
    public EventServiceDomain eventServiceDomain;
    private final Scanner scanner;

    public DeleteEventCommand(EventServiceDomain eventServiceDomain, Scanner scanner) {
        this.eventServiceDomain = eventServiceDomain;
        this.scanner = scanner;
    }

    @Override
    public void execute() {
        System.out.println("=== Удаление события ===");

        System.out.print("Имя события: ");
        String name = scanner.nextLine();
        this.eventServiceDomain.deleteEvent(name);
    }

    @Override
    public boolean supports(String userInput) {
        return CommandTriggers.DELETE_EVENT.contains(userInput);
    }
}
