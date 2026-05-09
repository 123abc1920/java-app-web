package com.abc1920.presentation.servlet;

import com.abc1920.domain.model.factory.AppFactory;
import com.abc1920.usecases.facades.EventServiceDomain;

import javax.servlet.http.HttpServlet;

public abstract class BaseServlet extends HttpServlet {
    protected static final EventServiceDomain domain;

    static {
        try {
            Class.forName("org.postgresql.Driver");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

        AppFactory appFactory = new AppFactory();
        domain = appFactory.createServlet();
    }
}

