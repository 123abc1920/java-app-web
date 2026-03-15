package com.abc1920.presentation.console.command.update;

import com.abc1920.domain.model.event.Event;
import com.abc1920.dto.EventDTO;
import com.abc1920.presentation.console.command.Command;
import com.abc1920.presentation.console.command.triggers.CommandTriggers;
import com.abc1920.usecases.facades.EventServiceDomain;

import java.util.List;
import java.util.Scanner;

public class UpdNameCommand implements UpdateCommand {
    private final Scanner scanner;
    private Event event;
    private final EventServiceDomain eventServiceDomain;

    public UpdNameCommand(Scanner scanner, EventServiceDomain eventServiceDomain) {
        this.scanner = scanner;
        this.eventServiceDomain = eventServiceDomain;
    }

    @Override
    public void execute() {
        System.out.print("Введите новое название: ");
        String newName = scanner.nextLine();

        EventDTO eventDTO = null;

        if (newName.trim().isEmpty()) {
            System.out.println("Название не может быть пустым!");
        } else {
            eventDTO = new EventDTO(event.getId(), newName, event.getDescription(), event.getDate(), event.isRepeatable());
        }

        this.eventServiceDomain.update(eventDTO);
    }

    @Override
    public boolean supports(String userInput) {
        return this.triggers().contains(userInput);
    }

    @Override
    public List<String> triggers() {
        return CommandTriggers.UPD_NAME;
    }

    @Override
    public void setEvent(Event event) {
        this.event = event;
    }
}
