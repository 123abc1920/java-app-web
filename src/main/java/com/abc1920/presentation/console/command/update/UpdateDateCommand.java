package com.abc1920.presentation.console.command.update;

import com.abc1920.domain.model.event.Event;
import com.abc1920.dto.EventDTO;
import com.abc1920.presentation.console.CommandResult;
import com.abc1920.presentation.console.command.triggers.CommandTriggers;
import com.abc1920.usecases.facades.EventServiceDomain;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Scanner;

public class UpdateDateCommand implements UpdateCommand {
    private final Scanner scanner;
    private final EventServiceDomain eventServiceDomain;

    private Event event;

    public UpdateDateCommand(Scanner scanner, EventServiceDomain eventServiceDomain) {
        this.scanner = scanner;
        this.eventServiceDomain = eventServiceDomain;
    }

    @Override
    public CommandResult execute() {
        System.out.print("Введите новую дату: ");
        String dateStr = this.scanner.nextLine();

        Date date = null;
        try {
            SimpleDateFormat formatter = new SimpleDateFormat("yyyy.MM.dd");
            date = formatter.parse(dateStr);
        } catch (ParseException e) {
            System.out.println("Неверный формат даты!");
            this.event = null;
            return CommandResult.CONTINUE;
        }

        EventDTO eventDTO = new EventDTO(event.getId(), event.getName(), event.getDescription(), date, event.isRepeatable());

        this.eventServiceDomain.update(eventDTO);

        return CommandResult.CONTINUE;
    }

    @Override
    public boolean supports(String userInput) {
        return this.triggers().contains(userInput);
    }

    @Override
    public List<String> triggers() {
        return CommandTriggers.UPD_DATE;
    }

    @Override
    public void setEvent(Event event) {
        this.event = event;
    }
}
