package com.abc1920.domain.model.factory;

import com.abc1920.data.InMemoryAppointmentRepository;
import com.abc1920.data.InMemoryBirthdayRepository;
import com.abc1920.data.JdbcAppointmentRepository;
import com.abc1920.data.JdbcBirthdayRepository;
import com.abc1920.domain.repository.AppointmentRepository;
import com.abc1920.domain.repository.BirthdayRepository;

public class RepositoryFactory {
    public BirthdayRepository createBirthdayRepositoryInMemory() {
        return new InMemoryBirthdayRepository();
    }

    public AppointmentRepository createAppointmentRepositoryInMemory() {
        return new InMemoryAppointmentRepository();
    }

    public BirthdayRepository createBirthdayRepositoryJdbc() {
        return new JdbcBirthdayRepository();
    }

    public AppointmentRepository createAppointmentRepositoryJdbc() {
        return new JdbcAppointmentRepository();
    }
}
