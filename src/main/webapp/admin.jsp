<%@ page language="java" contentType="text/html; charset=UTF-8"%>
<%@ page import="java.util.*" %>
<%
    String user = (String) session.getAttribute("user");
    if (user == null) {
        response.sendRedirect("login.jsp");
    }
%>
<!DOCTYPE html>
<html>
<head>
    <title>Admin Dashboard</title>
</head>
<body>
    <h2>Welcome, <%= user %></h2>
    <h3>Feedbacks:</h3>
    <%
        List<String> feedbackList = (List<String>) application.getAttribute("feedbackList");
        if (feedbackList != null) {
            for (String feedback : feedbackList) {
    %>
    <p><%= feedback %></p>
    <%  }
        } else { %>
    <p>No feedback available</p>
    <% } %>
</body>
</html>
