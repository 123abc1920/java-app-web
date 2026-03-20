package com.abc1920.domain.model.factory;

public class IdFactory {
    private int count = -1;

    public int generateId() {
        count++;
        return count;
    }
}
