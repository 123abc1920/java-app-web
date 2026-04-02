package com.abc1920.domain.model.factory;

import com.abc1920.domain.Consts;
import com.abc1920.domain.repository.AppointmentRepository;
import com.abc1920.domain.repository.BirthdayRepository;
import com.abc1920.presentation.console.CommandChain;
import com.abc1920.presentation.console.ConsolePresentation;
import com.abc1920.usecases.facades.EventServiceDomain;
import com.abc1920.usecases.services.AppointmentService;
import com.abc1920.usecases.services.BirthdayService;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

public class AppFactory {
    private final Scanner scanner = new Scanner(System.in);

    public void createInMemory() {
        RepositoryFactory repositoryFactory = new RepositoryFactory();
        ServiceFactory serviceFactory = new ServiceFactory();
        CommandFactory commandFactory = new CommandFactory();
        PresentationFactory presentationFactory = new PresentationFactory();
        EventFactory eventFactory = new EventFactory();

        BirthdayRepository birthdayRepository = repositoryFactory.createBirthdayRepositoryInMemory();
        BirthdayService birthdayService = serviceFactory.createBirthdayService(birthdayRepository);

        AppointmentRepository appointmentRepository = repositoryFactory.createAppointmentRepositoryInMemory();
        AppointmentService appointmentService = serviceFactory.createAppointmentService(appointmentRepository);

        EventServiceDomain eventServiceDomain = serviceFactory.createEventServiceDomain(appointmentService, birthdayService, eventFactory);

        CommandChain commandChain = commandFactory.createCommandChain(eventServiceDomain, scanner);

        ConsolePresentation presentation = presentationFactory.createConsolePresentation(commandChain);
        presentation.start();
    }

    private void createTablesIfNotExists() {
        try (Connection conn = Consts.getStartConnection();
             Statement stmt = conn.createStatement()) {
            stmt.execute("CREATE DATABASE organizer");
        } catch (SQLException e) {
        }

        String createBirthdayTable = """
                    CREATE TABLE IF NOT EXISTS birthday (
                        id SERIAL PRIMARY KEY,
                        name VARCHAR(100) NOT NULL,
                        date DATE NOT NULL,
                        description TEXT,
                        is_repeatable BOOLEAN DEFAULT TRUE
                    )
                """;

        String createAppointmentTable = """
                    CREATE TABLE IF NOT EXISTS appointment (
                        id SERIAL PRIMARY KEY,
                        name VARCHAR(100) NOT NULL,
                        date DATE NOT NULL,
                        description TEXT,
                        is_repeatable BOOLEAN DEFAULT FALSE
                    )
                """;

        try (Connection conn = Consts.getConnection();
             Statement stmt = conn.createStatement()) {

            stmt.execute(createBirthdayTable);
            stmt.execute(createAppointmentTable);
        } catch (SQLException e) {
            System.err.println("Error creating tables: " + e.getMessage());
            e.printStackTrace();
        }
    }

    public void createJdbc() {
        createTablesIfNotExists();

        RepositoryFactory repositoryFactory = new RepositoryFactory();
        ServiceFactory serviceFactory = new ServiceFactory();
        CommandFactory commandFactory = new CommandFactory();
        PresentationFactory presentationFactory = new PresentationFactory();
        EventFactory eventFactory = new EventFactory();

        BirthdayRepository birthdayRepository = repositoryFactory.createBirthdayRepositoryJdbc();
        BirthdayService birthdayService = serviceFactory.createBirthdayService(birthdayRepository);

        AppointmentRepository appointmentRepository = repositoryFactory.createAppointmentRepositoryJdbc();
        AppointmentService appointmentService = serviceFactory.createAppointmentService(appointmentRepository);

        EventServiceDomain eventServiceDomain = serviceFactory.createEventServiceDomain(appointmentService, birthdayService, eventFactory);

        CommandChain commandChain = commandFactory.createCommandChain(eventServiceDomain, scanner);

        ConsolePresentation presentation = presentationFactory.createConsolePresentation(commandChain);
        presentation.start();
    }
}
