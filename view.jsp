<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="java.util.*, java.util.Map" %>
<%
    List<Map<String, Object>> tasks = (List<Map<String, Object>>) request.getAttribute("tasks");
%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>View Tasks</title>
</head>
<body>
<h2>All Tasks</h2>
<ul>
    <% if (tasks != null && !tasks.isEmpty()) {
           for (Map<String, Object> task : tasks) {
               int id = (int) task.get("id");
               String title = (String) task.get("title");
               boolean isCompleted = (boolean) task.get("is_completed");
    %>
               <li>
                   <%= title %> 
                   <% if (!isCompleted) { %>
                       <a href="completeTask?id=<%= id %>">[Mark as Completed]</a>
                   <% } else { %>
                       (Completed)
                   <% } %>
               </li>
    <%     }
       } else { %>
           <li>No tasks found.</li>
    <% } %>
</ul>
<a href="index.jsp">Add Another Task</a>
</body>
</html>
