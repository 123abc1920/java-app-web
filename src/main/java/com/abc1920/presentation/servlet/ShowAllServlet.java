package com.abc1920.presentation.servlet;

import com.abc1920.domain.model.event.Event;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet("/show-events")
public class ShowAllServlet extends BaseServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        List<Event> events = domain.getAllEvents();
        req.setAttribute("events", events);

        req.getRequestDispatcher("/events.jsp").forward(req, resp);
    }
}

