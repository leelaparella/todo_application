<%@ page contentType="text/html; charset=UTF-8" language="java" %>
<html>
<head><title>To-Do List</title></head>
<body>
    <h2>Add New Task</h2>
    <form action="addTask" method="post">
        <input type="text" name="title" placeholder="Enter task title" required />
        <input type="submit" value="Add Task" />
    </form>
    <br />
    <a href="view">View Tasks</a>
</body>
</html>
