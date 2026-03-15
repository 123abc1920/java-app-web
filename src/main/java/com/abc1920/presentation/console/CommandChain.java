package com.abc1920.presentation.console;

import com.abc1920.presentation.console.command.*;

import java.util.List;

public class CommandChain {
    protected final List<Command> commands;

    public CommandChain(List<Command> commands) {
        this.commands = commands;
    }

    public void process(String userInput) {
        for (Command cmd : commands) {
            if (cmd.supports(userInput)) {
                cmd.execute();
                return;
            }
        }
        System.out.println("Команда не найдена");
    }

    public String getAll() {
        StringBuilder s = new StringBuilder();

        for (Command c : commands) {
            s.append(c.triggers().toString()).append("\n");
        }

        return s.toString().replaceAll("\\[", "").replaceAll("]", "");
    }
}
