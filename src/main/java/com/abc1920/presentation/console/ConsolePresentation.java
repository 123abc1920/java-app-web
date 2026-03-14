package com.abc1920.presentation.console;

import com.abc1920.usecases.facades.EventServiceDomain;

import java.util.Scanner;

// todo pattern command
// chain of responsibility

public class ConsolePresentation {
    private final Scanner scanner = new Scanner(System.in);
    private final EventServiceDomain eventServiceDomain;

    private CommandChain commandChain;

    public ConsolePresentation(EventServiceDomain eventServiceDomain, CommandChain commandChain) {
        this.eventServiceDomain = eventServiceDomain;
        this.commandChain = commandChain;
    }

    public void start() {
        printMenu();
        while (true) {
            String choice = scanner.nextLine();
            commandChain.process(choice);
        }
    }

    private void printMenu() {
        System.out.println(commandChain.getAll());
    }
}
