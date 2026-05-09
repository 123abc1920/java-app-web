package com.abc1920.presentation.servlet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/delete-event")
public class DeleteServlet extends BaseServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {
        String eventName = req.getParameter("name");

        if (eventName != null && !eventName.isEmpty()) {
            domain.deleteEvent(eventName);
        }

        resp.sendRedirect(req.getContextPath() + "/show-events");
    }
}