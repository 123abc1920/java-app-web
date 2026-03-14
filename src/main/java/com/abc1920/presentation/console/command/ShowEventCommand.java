package com.abc1920.presentation.console.command;

import com.abc1920.domain.model.event.Event;
import com.abc1920.presentation.console.command.triggers.CommandTriggers;
import com.abc1920.usecases.facades.EventServiceDomain;

import java.util.HashMap;

public class ShowEventCommand implements Command {
    EventServiceDomain eventServiceDomain;

    public ShowEventCommand(EventServiceDomain eventServiceDomain) {
        this.eventServiceDomain = eventServiceDomain;
    }

    @Override
    public void execute() {
        System.out.println("Список событий:");
        HashMap<Integer, Event> events = this.eventServiceDomain.getAllEvents();
        for (Event event : events.values()) {
            System.out.println(event.getName() + " " + event.getDescription() + " " + event.getDate() + " Повторяется: " + event.isRepeatable());
        }
    }

    @Override
    public boolean supports(String userInput) {
        return CommandTriggers.SHOW_EVENTS.contains(userInput);
    }
}
