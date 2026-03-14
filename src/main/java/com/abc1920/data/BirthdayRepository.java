package com.abc1920.data;

import com.abc1920.domain.model.event.Birthday;
import com.abc1920.domain.repository.CRUDRepository;

import java.util.HashMap;

public class BirthdayRepository implements CRUDRepository<Birthday> {
    private final HashMap<Integer, Birthday> events = new HashMap<Integer, Birthday>();

    @Override
    public HashMap<Integer, Birthday> getAll() {
        return events;
    }

    @Override
    public Birthday getById(int id) {
        return events.get(id);
    }

    @Override
    public void add(Birthday item) {
        events.put(item.getId(), item);
    }

    @Override
    public void delete(int id) {
        events.remove(id);
    }
}
