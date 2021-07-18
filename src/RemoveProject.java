import java.sql.SQLException;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(name = "RemoveProject", value = "/RemoveProject")
public class RemoveProject extends HttpServlet{
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {
        PrintWriter printWriter = response.getWriter();
        request.setCharacterEncoding("utf-8");
        response.setCharacterEncoding("utf-8");
        response.setHeader("content-type", "text/html;charset=utf-8");
        String member_1 = request.getParameter("member_1");
        String project_name = request.getParameter("project_name");


        database database = new database("root", "123456");

        ProjectUtil.deleteMember(project_name, member_1);
        response.sendRedirect("main.html?" + "id=" + member_1 + "&isNew=yes");
    }

}
