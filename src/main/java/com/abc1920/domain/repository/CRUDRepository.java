package com.abc1920.domain.repository;

import java.util.ArrayList;

public interface CRUDRepository<T> {
    ArrayList<T> getAll();

    T getById(int id);

    void add(T item);

    void delete(int id);

    boolean exists(int id);
}
