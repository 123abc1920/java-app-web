package com.abc1920.presentation.console.command;

import com.abc1920.presentation.console.command.triggers.CommandTriggers;

public class ExitCommand implements Command {
    @Override
    public void execute() {

    }

    @Override
    public boolean supports(String userInput) {
        return CommandTriggers.EXIT.contains(userInput);
    }
}
