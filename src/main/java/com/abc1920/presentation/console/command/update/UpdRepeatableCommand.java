package com.abc1920.presentation.console.command.update;

import com.abc1920.presentation.console.command.Command;

import java.util.List;

public class UpdRepeatableCommand implements Command {
    @Override
    public void execute() {

    }

    @Override
    public boolean supports(String userInput) {
        return false;
    }

    @Override
    public List<String> triggers() {
        return List.of();
    }
}
