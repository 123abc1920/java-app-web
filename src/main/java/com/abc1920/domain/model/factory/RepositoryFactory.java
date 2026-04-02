package com.abc1920.domain.model.factory;

import com.abc1920.data.InMemoryAppointmentRepository;
import com.abc1920.data.InMemoryBirthdayRepository;
import com.abc1920.domain.repository.AppointmentRepository;
import com.abc1920.domain.repository.BirthdayRepository;

public class RepositoryFactory {
    public BirthdayRepository createBirthdayRepository() {
        return new InMemoryBirthdayRepository();
    }

    public AppointmentRepository createAppointmentRepository() {
        return new InMemoryAppointmentRepository();
    }
}
