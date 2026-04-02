package com.abc1920;

import com.abc1920.domain.model.factory.AppFactory;

public class Main {
    public static void main(String[] args) {
        AppFactory appFactory = new AppFactory();
        appFactory.create();
    }
}