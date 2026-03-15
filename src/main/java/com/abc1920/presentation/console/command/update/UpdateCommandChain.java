package com.abc1920.presentation.console.command.update;

import com.abc1920.domain.model.event.Event;
import com.abc1920.presentation.console.CommandChain;
import com.abc1920.presentation.console.command.Command;

import java.util.List;

public class UpdateCommandChain {
    private final List<UpdateCommand> commands;

    public UpdateCommandChain(List<UpdateCommand> commands) {
        this.commands = commands;
    }

    public void process(String userInput, Event event) {
        for (UpdateCommand cmd : commands) {
            if (cmd.supports(userInput)) {
                cmd.setEvent(event);
                cmd.execute();
                cmd.setEvent(null);
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
