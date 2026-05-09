package com.abc1920.presentation.servlet;

import com.abc1920.dto.EventDTO;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

@WebServlet("/add-appointment")
public class AddAppointmentServlet extends BaseServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {
        req.getRequestDispatcher("/add-appointment.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {
        String dateStr = req.getParameter("date");
        String name = req.getParameter("name");
        String description = req.getParameter("description");
        String repeatable = req.getParameter("repeatable");

        Date date = null;
        try {
            SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
            date = formatter.parse(dateStr);
        } catch (ParseException e) {
            req.setAttribute("error", "Неверный формат даты!");
            req.getRequestDispatcher("/add-appointment.jsp").forward(req, resp);
            return;
        }

        System.out.println("llll");

        boolean isRepeat = "on".equals(repeatable);
        domain.addEvent(new EventDTO(false, name, description, date, isRepeat));

        resp.sendRedirect(req.getContextPath() + "/show-events");
    }
}