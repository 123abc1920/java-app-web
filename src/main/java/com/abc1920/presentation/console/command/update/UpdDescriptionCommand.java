package com.abc1920.presentation.console.command.update;

import com.abc1920.domain.model.event.Event;
import com.abc1920.dto.EventDTO;
import com.abc1920.presentation.console.command.triggers.CommandTriggers;
import com.abc1920.usecases.facades.EventServiceDomain;

import java.util.List;
import java.util.Scanner;

public class UpdDescriptionCommand implements UpdateCommand {
    private final Scanner scanner;
    private final EventServiceDomain eventServiceDomain;

    private Event event;

    public UpdDescriptionCommand(Scanner scanner, EventServiceDomain eventServiceDomain) {
        this.scanner = scanner;
        this.eventServiceDomain = eventServiceDomain;
    }

    @Override
    public void execute() {
        System.out.print("Введите новое описание: ");
        String newDesc = scanner.nextLine();

        EventDTO eventDTO = new EventDTO(event.getId(), event.getName(), newDesc, event.getDate(), event.isRepeatable());

        this.eventServiceDomain.update(eventDTO);
    }

    @Override
    public boolean supports(String userInput) {
        return this.triggers().contains(userInput);
    }

    @Override
    public List<String> triggers() {
        return CommandTriggers.UPD_DESCRIPTION;
    }

    @Override
    public void setEvent(Event event) {
        this.event = event;
    }
}
