package com.abc1920.presentation.console.command;

public interface Command {
    void execute();

    boolean supports(String userInput);
}
