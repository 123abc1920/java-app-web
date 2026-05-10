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

@WebServlet("/add-birthday")
public class AddBirthdayServlet extends BaseServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {
        req.getRequestDispatcher("/add-birthday.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {
        req.setCharacterEncoding("UTF-8");

        String dateStr = req.getParameter("date");
        String name = req.getParameter("name");
        String description = req.getParameter("description");

        Date date = null;
        try {
            SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
            date = formatter.parse(dateStr);
        } catch (ParseException e) {
            resp.setContentType("text/html;charset=UTF-8");
            resp.getWriter().println("<script>alert('Неверный формат даты!'); history.back();</script>");
            return;
        }

        domain.addEvent(new EventDTO(true, name, description, date, true));
        resp.sendRedirect(req.getContextPath() + "/show-events");
    }
}