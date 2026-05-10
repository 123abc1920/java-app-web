package com.abc1920.domain.repository;

import com.abc1920.dto.EventDTO;

import java.util.ArrayList;

public interface CRUDRepository<T> {
    ArrayList<T> getAll();

    T getById(int id);

    void add(T item);

    void delete(int id);

    void update(EventDTO event);

    boolean exists(EventDTO event);
}
