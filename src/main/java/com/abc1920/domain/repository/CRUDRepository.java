package com.abc1920.domain.repository;

import java.util.HashMap;

public interface CRUDRepository<T> {
    HashMap<Integer, T> getAll();

    T getById(int id);

    void add(T item);

    void delete(int id);
}
