package com.abc1920.presentation.servlet;

import com.abc1920.domain.model.event.Event;
import com.abc1920.dto.EventDTO;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

@WebServlet("/update-event")
public class UpdateServlet extends BaseServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {
        String eventName = req.getParameter("name");

        if (eventName != null && !eventName.isEmpty()) {
            Event event = domain.getByName(eventName);
            req.setAttribute("event", event);
        }

        req.getRequestDispatcher("/update-event.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {

        String dateStr = req.getParameter("date");
        String name = req.getParameter("newName");
        String oldName = req.getParameter("oldName");
        String description = req.getParameter("description");
        String repeatable = req.getParameter("repeatable");

        Date date = null;
        try {
            SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
            date = formatter.parse(dateStr);
        } catch (ParseException e) {
            req.setAttribute("error", "Неверный формат даты!");
            req.getRequestDispatcher("/update-event.jsp").forward(req, resp);
            return;
        }

        boolean isRepeat = "on".equals(repeatable);

        Event event = domain.getByName(oldName);
        domain.update(new EventDTO(event.getId(), event.getIsBirthday(), name, description, date, isRepeat));

        resp.sendRedirect(req.getContextPath() + "/show-events");
    }
}