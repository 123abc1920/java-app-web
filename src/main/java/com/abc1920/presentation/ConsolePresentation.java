package com.abc1920.presentation;

import com.abc1920.domain.model.event.Event;
import com.abc1920.domain.presentation.EventPresentation;
import com.abc1920.dto.EventDTO;
import com.abc1920.usecases.facades.EventServiceDomain;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Scanner;

// todo wildcard проверить
public class ConsolePresentation implements EventPresentation {
    private final Scanner scanner = new Scanner(System.in);
    private final EventServiceDomain eventServiceDomain;

    public ConsolePresentation(EventServiceDomain eventServiceDomain) {
        this.eventServiceDomain = eventServiceDomain;
    }

    public void start() {
        printMenu();
        while (true) {
            int choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {
                case 1 -> showEvents();
                case 2 -> addBirthday();
                case 3 -> addAppointment();
                case 4 -> deleteEvent();
                case 5 -> updateEvent();
                // todo pattern command
                // chain of responsibility
                case 0 -> {
                    return;
                }
            }
        }
    }

    private void printMenu() {
        System.out.println("\n=== МЕНЮ ===");
        System.out.println("1. Показать события");
        System.out.println("2. Добавить день рождения");
        System.out.println("3. Добавить встречу");
        System.out.println("4. Удалить событие");
        System.out.println("5. Обновить событие");
        System.out.println("0. Выход");
    }

    @Override
    public void showEvents() {
        System.out.println("Список событий:");
        HashMap<Integer, Event> events = this.eventServiceDomain.getAllEvents();
        for (Event event : events.values()) {
            System.out.println(event.getName() + " " + event.getDescription() + " " + event.getDate() + " Повторяется: " + event.isRepeatable());
        }
    }

    @Override
    public void addBirthday() {
        System.out.println("=== Добавление дня рождения ===");

        System.out.print("Введите дату: ");
        String dateStr = scanner.nextLine();
        Date date = null;
        try {
            SimpleDateFormat formatter = new SimpleDateFormat("dd.MM.yyyy");
            date = formatter.parse(dateStr);
        } catch (ParseException e) {
            System.out.println("Неверный формат даты!");
        }

        System.out.print("Введите имя: ");
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
    public void addAppointment() {
        System.out.println("=== Добавление встречи ===");

        System.out.print("Введите дату: ");
        String dateStr = scanner.nextLine();
        Date date = null;
        try {
            SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
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
    public void deleteEvent() {
        System.out.println("=== Удаление события ===");

        System.out.print("Имя события: ");
        String name = scanner.nextLine();
        this.eventServiceDomain.deleteEvent(name);
    }

    @Override
    public void updateEvent() {
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
        System.out.println("3 -- День");
        System.out.println("4 -- Месяц");
        System.out.println("5 -- Год");
        System.out.println("6 -- Повторяемость");
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
}
