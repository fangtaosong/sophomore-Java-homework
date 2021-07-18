import java.sql.SQLException;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(name = "changeTeamName", value = "/changeTeamName")
public class changeTeamName extends HttpServlet{
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {
        PrintWriter printWriter = response.getWriter();
        request.setCharacterEncoding("utf-8");
        response.setCharacterEncoding("utf-8");
        response.setHeader("content-type", "text/html;charset=utf-8");
        String member_1 = request.getParameter("member_1");
        String pro_name = request.getParameter("project_name");


        database database = new database("root", "123456");

        ProjectUtil.change_name(pro_name,member_1);
        project_item p = null;
        try {
            p = database.search(member_1);
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        assert p != null;
        System.out.println(p);
        System.out.println("a"+p.getinfo());
        if (p != null) {
            String Stemp = p.getinfo();
            System.out.println(Stemp);
            response.sendRedirect("main.html?" + "id=" + member_1 + "&pw1=" + member_1 + Stemp);
        } else {
            response.sendRedirect("main.html?" + "id=" + member_1 + "&pw1=" + member_1);
        }

    }
}
