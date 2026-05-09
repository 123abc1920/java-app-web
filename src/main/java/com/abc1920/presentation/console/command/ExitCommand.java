package com.abc1920.presentation.console.command;

import com.abc1920.presentation.console.CommandResult;
import com.abc1920.presentation.console.command.triggers.CommandTriggers;

import java.util.List;

public class ExitCommand implements Command {
    @Override
    public CommandResult execute() {
        return CommandResult.EXIT;
    }

    @Override
    public boolean supports(String userInput) {
        return this.triggers().contains(userInput);
    }

    @Override
    public List<String> triggers() {
        return CommandTriggers.EXIT;
    }
}
