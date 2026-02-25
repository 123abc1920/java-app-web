package com.abc1920;

import com.abc1920.data.InMemoryRepository;
import com.abc1920.domain.model.factory.EventFactory;
import com.abc1920.presentation.ConsolePresentation;
import com.abc1920.usecases.facades.EventFacade;
import com.abc1920.usecases.services.AddEventService;
import com.abc1920.usecases.services.GetEventService;

public class Main {
    public static void main(String[] args) {
        InMemoryRepository inMemoryRepository = new InMemoryRepository();

        EventFactory eventFactory = new EventFactory();
        AddEventService addEventService = new AddEventService(eventFactory, inMemoryRepository);
        GetEventService getEventService = new GetEventService(inMemoryRepository);

        EventFacade eventFacade = new EventFacade(addEventService, getEventService);

        ConsolePresentation presentation = new ConsolePresentation(eventFacade);
        presentation.start();
    }
}