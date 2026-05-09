package com.abc1920.presentation.console.command;

import com.abc1920.presentation.console.CommandResult;

import java.util.List;

public interface Command {
    CommandResult execute();

    boolean supports(String userInput);

    List<String> triggers();
}
