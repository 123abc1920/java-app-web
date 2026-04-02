package com.abc1920.presentation.console.command;

import com.abc1920.domain.model.event.Event;
import com.abc1920.presentation.console.CommandResult;
import com.abc1920.presentation.console.command.triggers.CommandTriggers;
import com.abc1920.usecases.facades.EventServiceDomain;

import java.text.SimpleDateFormat;
import java.util.HashMap;
import java.util.List;

public class ShowEventCommand implements Command {
    EventServiceDomain eventServiceDomain;

    public ShowEventCommand(EventServiceDomain eventServiceDomain) {
        this.eventServiceDomain = eventServiceDomain;
    }

    @Override
    public CommandResult execute() {
        System.out.println("Список событий:");
        HashMap<Integer, Event> events = this.eventServiceDomain.getAllEvents();
        SimpleDateFormat formatter = new SimpleDateFormat("dd.MM.yyyy");

        for (Event event : events.values()) {
            System.out.println(event.getId() + " " + event.getName() + " " + event.getDescription() + " " + formatter.format(event.getDate()) + " Повторяется: " + event.isRepeatable());
        }

        return CommandResult.CONTINUE;
    }

    @Override
    public boolean supports(String userInput) {
        return this.triggers().contains(userInput);
    }

    @Override
    public List<String> triggers() {
        return CommandTriggers.SHOW_EVENTS;
    }
}
