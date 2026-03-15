package com.abc1920.usecases.services;

import com.abc1920.data.BirthdayRepository;
import com.abc1920.domain.model.event.Birthday;
import com.abc1920.domain.model.event.Event;
import com.abc1920.dto.EventDTO;

import java.util.HashMap;

public class BirthdayService {
    private final BirthdayRepository birthdayRepository;

    public BirthdayService(BirthdayRepository birthdayRepository) {
        this.birthdayRepository = birthdayRepository;
    }

    public Birthday get(int id) {
        return this.birthdayRepository.getById(id);
    }

    public Birthday getByName(String name) {
        for (Birthday b : birthdayRepository.getAll().values()) {
            if (name.equals(b.getName())) {
                return b;
            }
        }
        return null;
    }

    public HashMap<Integer, Birthday> getAllBirthdays() {
        return this.birthdayRepository.getAll();
    }

    public int getId(String name) {
        int i = 0;
        for (Event e : this.birthdayRepository.getAll().values()) {
            if (e.getName().equals(name)) {
                return i;
            }
            i++;
        }
        return -1;
    }

    public void add(Birthday item) {
        this.birthdayRepository.add(item);
    }

    public void delete(int id) {
        this.birthdayRepository.delete(id);
    }

    public void update(EventDTO eventDTO) {
        Birthday event = this.birthdayRepository.getById(eventDTO.getId());
        event.setDate(eventDTO.getDate());
        event.setDescription(eventDTO.getDescription());
        event.setName(eventDTO.getName());
        event.setRepeatable(eventDTO.getIsRepeatable());
    }
}
