package todo_application;

import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;
import java.sql.*;

public class AddTaskServlet extends HttpServlet {
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String title = req.getParameter("title");

        try (Connection conn = DBUtil.getConnection()) {
            String sql = "INSERT INTO tasks (title, is_completed) VALUES (?, false)";
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1, title);
            ps.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }

        resp.sendRedirect("view");
        System.out.println("Received Task Title: " + title);
    }
}
