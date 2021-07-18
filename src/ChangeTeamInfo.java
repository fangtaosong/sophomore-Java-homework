import java.sql.SQLException;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(name = "ChangeTeamInfo", value = "/ChangeTeamInfo")
public class ChangeTeamInfo extends HttpServlet {

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {
        PrintWriter printWriter = response.getWriter();
        request.setCharacterEncoding("utf-8");
        response.setCharacterEncoding("utf-8");
        response.setHeader("content-type", "text/html;charset=utf-8");
        String member_1 = request.getParameter("member_1");
        String member_2 = request.getParameter("member_2");
        String member_3 = request.getParameter("member_3");
        String member_4 = request.getParameter("member_4");
        String member_5 = request.getParameter("member_5");

        database database = new database("root", "123456");

        ProjectUtil.change(member_1, member_2, member_3, member_4, member_5);
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
