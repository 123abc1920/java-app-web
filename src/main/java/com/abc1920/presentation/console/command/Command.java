package com.abc1920.presentation.console.command;

import java.util.List;

public interface Command {
    void execute();

    boolean supports(String userInput);

    List<String> triggers();
}
