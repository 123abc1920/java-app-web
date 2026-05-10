package com.abc1920.data;

import com.abc1920.domain.model.event.Birthday;
import com.abc1920.domain.model.event.Event;
import com.abc1920.domain.model.factory.IdFactory;
import com.abc1920.domain.repository.BirthdayRepository;
import com.abc1920.domain.repository.CRUDRepository;
import com.abc1920.dto.EventDTO;

import java.util.ArrayList;
import java.util.HashMap;

public class InMemoryBirthdayRepository implements BirthdayRepository {
    private final HashMap<Integer, Birthday> events = new HashMap<Integer, Birthday>();
    private final IdFactory idFactory = new IdFactory();

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
        int id = idFactory.generateId();
        item.setId(id);
        events.put(id, item);
    }

    @Override
    public void delete(int id) {
        events.remove(id);
    }

    @Override
    public void update(EventDTO event) {

    }

    @Override
    public boolean exists(EventDTO event) {
        for (Event e : this.events.values()) {
            if (e.equals(event)) {
                return true;
            }
        }

        return false;
    }
}
