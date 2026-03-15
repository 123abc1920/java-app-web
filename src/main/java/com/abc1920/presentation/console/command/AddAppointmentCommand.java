package com.abc1920.presentation.console.command;

import com.abc1920.dto.EventDTO;
import com.abc1920.presentation.console.command.triggers.CommandTriggers;
import com.abc1920.usecases.facades.EventServiceDomain;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Scanner;

public class AddAppointmentCommand implements Command {
    private final EventServiceDomain eventServiceDomain;
    private final Scanner scanner;

    public AddAppointmentCommand(EventServiceDomain eventServiceDomain, Scanner scanner) {
        this.eventServiceDomain = eventServiceDomain;
        this.scanner = scanner;
    }

    @Override
    public void execute() {
        System.out.println("=== Добавление встречи ===");

        System.out.print("Введите дату: ");
        String dateStr = scanner.nextLine();
        Date date = null;
        try {
            SimpleDateFormat formatter = new SimpleDateFormat("yyyy.MM.dd");
            date = formatter.parse(dateStr);
        } catch (ParseException e) {
            System.out.println("Неверный формат даты!");
        }

        System.out.print("Введите название встречи: ");
        String name = scanner.nextLine();

        System.out.print("Введите описание: ");
        String description = scanner.nextLine();

        System.out.print("Это повторяющееся событие? (true/false): ");
        boolean isRepeat = scanner.nextBoolean();

        if (date != null) {
            this.eventServiceDomain.addEvent(new EventDTO(true, name, description, date, isRepeat));
            System.out.println("День рождения добавлен!");
        }
    }

    @Override
    public boolean supports(String userInput) {
        return this.triggers().contains(userInput);
    }

    @Override
    public List<String> triggers() {
        return CommandTriggers.ADD_APPOINTMENT;
    }
}
