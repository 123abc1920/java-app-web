package com.abc1920.data;

import com.abc1920.domain.model.event.Birthday;
import com.abc1920.domain.repository.BirthdayRepository;
import com.abc1920.domain.repository.CRUDRepository;

import java.util.ArrayList;
import java.util.HashMap;

public class InMemoryBirthdayRepository implements BirthdayRepository {
    private final HashMap<Integer, Birthday> events = new HashMap<Integer, Birthday>();

    @Override
    public ArrayList<Birthday> getAll() {
        return new ArrayList<>(events.values());
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

    @Override
    public boolean exists(int id) {
        return events.containsKey(id);
    }
}
