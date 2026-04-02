package com.abc1920.domain.model.factory;

// TODO: не сокращать названия
public class IdFactory {
    private int count = 0;

    public int generateId() {
        return count++;
    }
}
