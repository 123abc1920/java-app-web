package com.abc1920.presentation;

import com.abc1920.domain.model.Month;
import com.abc1920.domain.model.event.Event;
import com.abc1920.domain.presentation.IPresentation;
import com.abc1920.usecases.facades.EventFacade;

import java.util.List;
import java.util.Scanner;

public class ConsolePresentation implements IPresentation {
    private Scanner scanner = new Scanner(System.in);
    private EventFacade eventFacade;

    public ConsolePresentation(EventFacade eventFacade) {
        this.eventFacade = eventFacade;
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
        List<Event> events = this.eventFacade.getAllEvents();
        for (Event event : events) {
            System.out.println(event.getName() + " " + event.getDescription() + " " + event.getDay() + "." + event.getMonth() + "." + event.getYear() + " Повторяется: " + event.isRepeatable());
        }
    }

    @Override
    public void addBirthday() {
        System.out.println("=== Добавление дня рождения ===");

        System.out.print("Введите день (1-31): ");
        int day = scanner.nextInt();

        System.out.print("Введите месяц (1-12): ");
        int monthValue = scanner.nextInt();
        Month month = Month.values()[monthValue - 1];

        System.out.print("Введите год: ");
        int year = scanner.nextInt();
        scanner.nextLine();

        System.out.print("Введите имя: ");
        String name = scanner.nextLine();

        System.out.print("Введите описание: ");
        String description = scanner.nextLine();

        System.out.print("Это повторяющееся событие? (true/false): ");
        boolean isRepeat = scanner.nextBoolean();

        System.out.println("День рождения добавлен!");
        this.eventFacade.addEvent(true, day, month, year, name, description, isRepeat);
    }

    @Override
    public void addAppointment() {
        System.out.println("=== Добавление встречи ===");

        System.out.print("Введите день (1-31): ");
        int day = scanner.nextInt();

        System.out.print("Введите месяц (1-12): ");
        int monthValue = scanner.nextInt();
        Month month = Month.values()[monthValue - 1];

        System.out.print("Введите год: ");
        int year = scanner.nextInt();
        scanner.nextLine();

        System.out.print("Введите название встречи: ");
        String name = scanner.nextLine();

        System.out.print("Введите описание: ");
        String description = scanner.nextLine();

        System.out.print("Это повторяющееся событие? (true/false): ");
        boolean isRepeat = scanner.nextBoolean();

        System.out.println("Встреча добавлена!");
        this.eventFacade.addEvent(false, day, month, year, name, description, isRepeat);
    }

    @Override
    public void deleteEvent() {
        System.out.println("=== Удаление события ===");

        System.out.print("Имя события: ");
        String name = scanner.nextLine();
        this.eventFacade.deleteEvent(name);
    }

    @Override
    public void updateEvent() {
        System.out.println("===================================");
        System.out.println("         ОБНОВЛЕНИЕ СОБЫТИЯ        ");
        System.out.println("===================================");

        System.out.print("Введите имя события для поиска: ");
        String name = scanner.nextLine();

        int id = this.eventFacade.getId(name);

        if (id == -1) {
            System.out.println("Событие с именем \"" + name + "\" не найдено!");
            return;
        }

        System.out.println("1 -- Название события");
        System.out.println("2 -- Описание события");
        System.out.println("3 -- День");
        System.out.println("4 -- Месяц");
        System.out.println("5 -- Год");
        System.out.println("0 -- Отмена");

        int choice = scanner.nextInt();
        scanner.nextLine();

        switch (choice) {
            case 1 -> {
                System.out.print("Введите новое название: ");
                String newName = scanner.nextLine();

                if (newName.trim().isEmpty()) {
                    System.out.println("Название не может быть пустым!");
                } else {
                    this.eventFacade.updateName(id, newName);
                    System.out.println("Название успешно обновлено на \"" + newName + "\"");
                }
            }
            case 2 -> {
                System.out.print("Введите новое описание: ");
                String newDesc = scanner.nextLine();
                this.eventFacade.updateDescription(id, newDesc);
                System.out.println("Описание успешно обновлено");
            }
            case 3 -> {
                System.out.print("Введите новый день (1-31): ");
                int newDay = scanner.nextInt();
                scanner.nextLine();

                if (newDay < 1 || newDay > 31) {
                    System.out.println("День должен быть в диапазоне от 1 до 31!");
                } else {
                    this.eventFacade.updateDay(id, newDay);
                    System.out.println("День успешно обновлен на " + newDay);
                }
            }
            case 4 -> {
                System.out.print("Введите номер нового месяца (1-12): ");
                int newMonth = scanner.nextInt();
                scanner.nextLine();

                if (newMonth < 1 || newMonth > 12) {
                    System.out.println("Месяц должен быть в диапазоне от 1 до 12!");
                } else {
                    this.eventFacade.updateMonth(id, Month.values()[newMonth - 1]);
                    System.out.println("Месяц успешно обновлен на " + Month.values()[newMonth - 1]);
                }
            }
            case 5 -> {
                System.out.print("Введите новый год: ");
                int newYear = scanner.nextInt();
                scanner.nextLine();

                if (newYear < 2024) {
                    System.out.println("Вы ввели год в прошлом. Продолжить? (y/n): ");
                    String confirm = scanner.nextLine();
                    if (confirm.equalsIgnoreCase("y")) {
                        this.eventFacade.updateYear(id, newYear);
                        System.out.println("Год успешно обновлен на " + newYear);
                    } else {
                        System.out.println("Обновление года отменено");
                    }
                } else {
                    this.eventFacade.updateYear(id, newYear);
                    System.out.println("Год успешно обновлен на " + newYear);
                }
            }
            case 0 -> {
                System.out.println("Обновление события отменено");
                return;
            }
            default -> {
                System.out.println("Выберите от 0 до 5");
            }
        }
    }
}
