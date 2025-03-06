package com.backend;



import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


public class feedbackServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String feedback = request.getParameter("feedback");
        ServletContext context = getServletContext();

        List<String> feedbackList = (List<String>) context.getAttribute("feedbackList");
        if (feedbackList == null) {
            feedbackList = new ArrayList<>();
        }

        feedbackList.add(feedback);
        context.setAttribute("feedbackList", feedbackList);

        response.getWriter().println("Feedback submitted!");
        response.sendRedirect("index.html");
    }
}
