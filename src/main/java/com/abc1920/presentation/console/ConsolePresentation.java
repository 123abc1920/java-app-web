package com.abc1920.presentation.console;

import java.util.Scanner;

public class ConsolePresentation {
    private final Scanner scanner = new Scanner(System.in);

    private final CommandChain commandChain;

    public ConsolePresentation(CommandChain commandChain) {
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
