package com.abc1920.presentation.console.command;

import com.abc1920.dto.EventDTO;
import com.abc1920.presentation.console.command.triggers.CommandTriggers;
import com.abc1920.usecases.facades.EventServiceDomain;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Scanner;

public class AddBirthdayCommand implements Command {
    private final EventServiceDomain eventServiceDomain;
    private final Scanner scanner;

    public AddBirthdayCommand(EventServiceDomain eventServiceDomain, Scanner scanner) {
        this.eventServiceDomain = eventServiceDomain;
        this.scanner = scanner;
    }

    @Override
    public void execute() {
        System.out.println("=== Добавление дня рождения ===");

        System.out.print("Введите дату: ");
        String dateStr = scanner.nextLine();
        Date date = null;
        try {
            SimpleDateFormat formatter = new SimpleDateFormat("dd.MM.yyyy");
            date = formatter.parse(dateStr);
        } catch (ParseException e) {
            System.out.println("Неверный формат даты!");
            return;
        }

        System.out.print("Введите имя: ");
        String name = scanner.nextLine();

        System.out.print("Введите описание: ");
        String description = scanner.nextLine();

        if (date != null) {
            this.eventServiceDomain.addEvent(new EventDTO(true, name, description, date, true));
            System.out.println("День рождения добавлен!");
        }
    }

    @Override
    public boolean supports(String userInput) {
        return this.triggers().contains(userInput);
    }

    @Override
    public List<String> triggers() {
        return CommandTriggers.ADD_BIRTHDAY;
    }
}
