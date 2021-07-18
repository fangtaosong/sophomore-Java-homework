import java.sql.SQLException;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
@WebServlet(name = "admin_change", value = "/admin_change")
public class admin_change extends HttpServlet{
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException
    {
        PrintWriter printWriter = response.getWriter();
        request.setCharacterEncoding("utf-8");
        response.setCharacterEncoding("utf-8");
        response.setHeader("content-type", "text/html;charset=utf-8");
        String id = request.getParameter("id");
        String name = request.getParameter("name");
        String member_1 = request.getParameter("member_1");
        String stage = request.getParameter("stage");
        String projectlevel = request.getParameter("projectlevel");
        database database = new database("root", "123456");
        ProjectUtil.admin_change(id, name, member_1, stage, projectlevel);
        response.sendRedirect("index.jsp");
    }
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException
    {
        PrintWriter printWriter = response.getWriter();
        request.setCharacterEncoding("utf-8");
        response.setCharacterEncoding("utf-8");
        response.setHeader("content-type", "text/html;charset=utf-8");
        String id = request.getParameter("id");
        String name = request.getParameter("name");
        String member_1 = request.getParameter("member_1");
        String stage = request.getParameter("stage");
        String projectlevel = request.getParameter("projectlevel");
        database database = new database("root", "123456");
        ProjectUtil.admin_change(id, name, member_1, stage, projectlevel);
        response.sendRedirect("index_hidden.jsp");

    }

}
