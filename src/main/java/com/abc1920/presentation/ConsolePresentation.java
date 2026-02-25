package com.abc1920.presentation;

import com.abc1920.domain.model.Month;
import com.abc1920.domain.model.event.Event;
import com.abc1920.domain.presentation.IPresentation;
import com.abc1920.usecases.facades.EventFacade;
import com.abc1920.usecases.services.AddEventService;
import com.abc1920.usecases.services.GetEventService;

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

            switch (choice) {
                case 1 -> showEvents();
                case 2 -> addBirthday();
                case 3 -> addAppointment();
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

        System.out.print("Введите имя именинника: ");
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
}
