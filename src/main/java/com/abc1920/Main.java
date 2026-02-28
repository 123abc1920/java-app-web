package com.abc1920;

import com.abc1920.data.InMemoryRepository;
import com.abc1920.domain.model.factory.EventFactory;
import com.abc1920.presentation.ConsolePresentation;
import com.abc1920.usecases.facades.EventFacade;

public class Main {
    public static void main(String[] args) {
        InMemoryRepository inMemoryRepository = new InMemoryRepository();

        EventFacade eventFacade = new EventFacade(inMemoryRepository, new EventFactory());

        ConsolePresentation presentation = new ConsolePresentation(eventFacade);
        presentation.start();
    }
}