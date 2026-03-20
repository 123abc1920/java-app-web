package com.abc1920.domain.model.factory;

import com.abc1920.presentation.console.CommandChain;
import com.abc1920.presentation.console.ConsolePresentation;

public class PresentationFactory {
    public ConsolePresentation createConsolePresentation(CommandChain commandChain) {
        return new ConsolePresentation(commandChain);
    }
}
