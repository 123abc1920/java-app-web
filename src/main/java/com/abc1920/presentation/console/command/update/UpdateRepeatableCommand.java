package com.abc1920.presentation.console.command.update;

import com.abc1920.domain.model.event.Event;
import com.abc1920.dto.EventDTO;
import com.abc1920.presentation.console.CommandResult;
import com.abc1920.presentation.console.command.triggers.CommandTriggers;
import com.abc1920.usecases.facades.EventServiceDomain;

import java.util.List;
import java.util.Scanner;

public class UpdateRepeatableCommand implements UpdateCommand {
    private final Scanner scanner;
    private final EventServiceDomain eventServiceDomain;

    private Event event;

    public UpdateRepeatableCommand(Scanner scanner, EventServiceDomain eventServiceDomain) {
        this.scanner = scanner;
        this.eventServiceDomain = eventServiceDomain;
    }

    @Override
    public CommandResult execute() {
        System.out.print("Это повторяющееся событие? (true/false): ");
        boolean isRepeat = scanner.nextBoolean();
        scanner.nextLine();

        EventDTO eventDTO = new EventDTO(event.getId(), event.getName(), event.getDescription(), event.getDate(), isRepeat);

        this.eventServiceDomain.update(eventDTO);

        return CommandResult.CONTINUE;
    }

    @Override
    public boolean supports(String userInput) {
        return this.triggers().contains(userInput);
    }

    @Override
    public List<String> triggers() {
        return CommandTriggers.UPD_REPEAT;
    }

    @Override
    public void setEvent(Event event) {
        this.event = event;
    }
}
