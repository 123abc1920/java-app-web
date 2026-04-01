package com.abc1920.presentation.console.command;

import com.abc1920.domain.model.event.Event;
import com.abc1920.presentation.console.CommandResult;
import com.abc1920.presentation.console.command.triggers.CommandTriggers;
import com.abc1920.presentation.console.command.update.UpdDateCommand;
import com.abc1920.presentation.console.command.update.UpdDescriptionCommand;
import com.abc1920.presentation.console.command.update.UpdateCommand;
import com.abc1920.presentation.console.command.update.UpdateCommandChain;
import com.abc1920.presentation.console.command.update.UpdNameCommand;
import com.abc1920.presentation.console.command.update.UpdRepeatableCommand;
import com.abc1920.usecases.facades.EventServiceDomain;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class UpdateEventCommand implements Command {
    private final EventServiceDomain eventServiceDomain;
    private final Scanner scanner;
    private UpdateCommandChain updateCommandChain;

    public UpdateEventCommand(EventServiceDomain eventServiceDomain, Scanner scanner) {
        this.eventServiceDomain = eventServiceDomain;
        this.scanner = scanner;

        this.updateCommandChain = createUpdateChain(scanner, eventServiceDomain);
    }

    private UpdateCommandChain createUpdateChain(Scanner scanner, EventServiceDomain eventServiceDomain) {
        List<UpdateCommand> commands = new ArrayList<>();

        commands.add(new UpdDateCommand(scanner, eventServiceDomain));
        commands.add(new UpdDescriptionCommand(scanner, eventServiceDomain));
        commands.add(new UpdNameCommand(scanner, eventServiceDomain));
        commands.add(new UpdRepeatableCommand(scanner, eventServiceDomain));

        return new UpdateCommandChain(commands);
    }

    @Override
    public CommandResult execute() {
        System.out.println("ОБНОВЛЕНИЕ СОБЫТИЯ");

        System.out.print("Введите имя события для поиска: ");
        String name = scanner.nextLine();

        Event event = this.eventServiceDomain.getByName(name);

        if (event == null) {
            System.out.println("Событие с именем \"" + name + "\" не найдено!");
            return CommandResult.CONTINUE;
        }

        System.out.println(updateCommandChain.getAll());

        String choice = scanner.nextLine();
        updateCommandChain.process(choice, event);

        return CommandResult.CONTINUE;
    }

    @Override
    public boolean supports(String userInput) {
        return this.triggers().contains(userInput);
    }

    @Override
    public List<String> triggers() {
        return CommandTriggers.UPDATE_EVENT;
    }
}
