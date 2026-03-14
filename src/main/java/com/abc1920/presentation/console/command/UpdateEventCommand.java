package com.abc1920.presentation.console.command;

import com.abc1920.domain.model.event.Event;
import com.abc1920.dto.EventDTO;
import com.abc1920.presentation.console.command.triggers.CommandTriggers;
import com.abc1920.usecases.facades.EventServiceDomain;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

public class UpdateEventCommand implements Command {
    private EventServiceDomain eventServiceDomain;
    private Scanner scanner;

    public UpdateEventCommand(EventServiceDomain eventServiceDomain, Scanner scanner) {
        this.eventServiceDomain = eventServiceDomain;
        this.scanner = scanner;
    }

    @Override
    public void execute() {
        System.out.println("===================================");
        System.out.println("         ОБНОВЛЕНИЕ СОБЫТИЯ        ");
        System.out.println("===================================");

        System.out.print("Введите имя события для поиска: ");
        String name = scanner.nextLine();

        Event event = this.eventServiceDomain.getByName(name);

        if (event == null) {
            System.out.println("Событие с именем \"" + name + "\" не найдено!");
            return;
        }

        System.out.println("1 -- Название события");
        System.out.println("2 -- Описание события");
        System.out.println("3 -- Дата");
        System.out.println("4 -- Повторяемость");
        System.out.println("0 -- Отмена");

        int choice = scanner.nextInt();
        scanner.nextLine();

        EventDTO eventDTO = null;

        switch (choice) {
            case 1 -> {
                System.out.print("Введите новое название: ");
                String newName = scanner.nextLine();

                if (newName.trim().isEmpty()) {
                    System.out.println("Название не может быть пустым!");
                } else {
                    eventDTO = new EventDTO(event.getId(), newName, event.getDescription(), event.getDate(), event.isRepeatable());
                }
            }
            case 2 -> {
                System.out.print("Введите новое описание: ");
                String newDesc = scanner.nextLine();
                eventDTO = new EventDTO(event.getId(), event.getName(), newDesc, event.getDate(), event.isRepeatable());
            }
            case 3 -> {
                System.out.print("Введите новую дату: ");
                String dateStr = scanner.nextLine();
                Date date = null;
                try {
                    SimpleDateFormat formatter = new SimpleDateFormat("yyyy.MM.dd");
                    date = formatter.parse(dateStr);
                } catch (ParseException e) {
                    System.out.println("Неверный формат даты!");
                    return;
                }

                eventDTO = new EventDTO(event.getId(), event.getName(), event.getDescription(), date, event.isRepeatable());
            }
            case 4 -> {
                System.out.print("Это повторяющееся событие? (true/false): ");
                boolean isRepeat = scanner.nextBoolean();
                eventDTO = new EventDTO(event.getId(), event.getName(), event.getDescription(), event.getDate(), isRepeat);
            }
            case 0 -> {
                System.out.println("Обновление события отменено");
                return;
            }
            default -> {
                System.out.println("Выберите от 0 до 4");
                return;
            }
        }

        this.eventServiceDomain.update(eventDTO);

    }

    @Override
    public boolean supports(String userInput) {
        return CommandTriggers.UPDATE_EVENT.contains(userInput);
    }
}
