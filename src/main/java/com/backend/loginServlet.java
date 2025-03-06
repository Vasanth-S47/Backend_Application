package com.backend;

import java.io.IOException;
import javax.servlet.ServletConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


public class loginServlet extends HttpServlet {
    private String adminUser;
    private String adminPass;

    public void init(ServletConfig config) throws ServletException {
        super.init(config);
        adminUser = config.getInitParameter("adminUser");
        adminPass = config.getInitParameter("adminPass");
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String username = request.getParameter("username");
        String password = request.getParameter("password");

        if (username.equals(adminUser) && password.equals(adminPass)) {
            HttpSession session = request.getSession();
            session.setAttribute("user", username);
            response.sendRedirect("admin.jsp");
        } else {
            response.getWriter().println("Invalid credentials. <a href='login.jsp'>Try again</a>");
        }
    }
}

