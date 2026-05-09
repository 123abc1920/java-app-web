package com.abc1920.presentation.console.command.triggers;

import java.util.Arrays;
import java.util.List;

public final class CommandTriggers {
    private CommandTriggers() {
    }

    public static final List<String> SHOW_EVENTS = Arrays.asList(
            "show", "list", "1"
    );

    public static final List<String> ADD_BIRTHDAY = Arrays.asList(
            "add bday", "add birthday", "2"
    );

    public static final List<String> ADD_APPOINTMENT = Arrays.asList(
            "add appointment", "add appointment", "3"
    );

    public static final List<String> DELETE_EVENT = Arrays.asList(
            "delete", "del", "4"
    );

    public static final List<String> UPDATE_EVENT = Arrays.asList(
            "upd event", "update", "upd", "5"
    );

    public static final List<String> EXIT = Arrays.asList(
            "exit", "quit", "0"
    );

    public static final List<String> UPD_NAME = Arrays.asList("name", "1");
    public static final List<String> UPD_DESCRIPTION = Arrays.asList("description", "desc", "2");
    public static final List<String> UPD_DATE = Arrays.asList("date", "3");
    public static final List<String> UPD_REPEAT = Arrays.asList("repeatable", "repeat", "4");
}
