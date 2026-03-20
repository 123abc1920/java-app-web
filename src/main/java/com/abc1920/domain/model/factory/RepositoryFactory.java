package com.abc1920.domain.model.factory;

import com.abc1920.data.AppointmentRepository;
import com.abc1920.data.BirthdayRepository;

public class RepositoryFactory {
    public BirthdayRepository createBirthdayRepository() {
        return new BirthdayRepository();
    }

    public AppointmentRepository createAppointmentRepository() {
        return new AppointmentRepository();
    }
}
