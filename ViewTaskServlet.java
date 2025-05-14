package todo_application;

import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;
import java.sql.*;
import java.util.*;

public class ViewTaskServlet extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        List<String> tasks = new ArrayList<>();

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/todo_app", "root", "");

            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery("SELECT title FROM tasks");

            while (rs.next()) {
                tasks.add(rs.getString("title"));
            }

            request.setAttribute("tasks", tasks);
            RequestDispatcher rd = request.getRequestDispatcher("view.jsp");
            rd.forward(request, response);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
