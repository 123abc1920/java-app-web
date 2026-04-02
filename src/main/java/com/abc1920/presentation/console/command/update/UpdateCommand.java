package com.abc1920.presentation.console.command.update;

import com.abc1920.domain.model.event.Event;
import com.abc1920.presentation.console.command.Command;

public interface UpdateCommand extends Command {
    void setEvent(Event event);
}
