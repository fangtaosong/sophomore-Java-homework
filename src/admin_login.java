import java.sql.SQLException;
import java.sql.*;
import java.util.*;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
@WebServlet(name = "admin_login", value = "/admin_login")
public class admin_login extends HttpServlet{

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {
//        response.sendRedirect("main_admin.jsp?" + "type=hidden");
        Connection ct = null;
        Statement  sm = null;
        ResultSet rs = null;
        try{
            Class.forName("com.mysql.jdbc.Driver");     //连接mysql数据库
            ct = DriverManager.getConnection("jdbc:mysql://localhost:3306/cippus_sys","root", "123456");
            sm = ct.createStatement();
            rs = sm.executeQuery("select *from project_list");

            List<project_item> users = new ArrayList<project_item>();
            while (rs.next()){
                project_item user = new project_item(rs.getInt("id"),rs.getString("name"),rs.getString("member_1")
                        ,rs.getString("member_2"),rs.getString("member_3"),rs.getString("member_4"),rs.getString("member_5"),
                        rs.getString("stage"),rs.getString("projectlevel"),rs.getString("fileid"));//每次都新建一个对象
                System.out.println(user.name);
                users.add(user);
            }
            request.setAttribute("fx","老师");
            request.setAttribute("users",users); //将需要送到jsp的数据放到request请求域中,让request帮忙带到jsp
            System.out.println(users.get(1).name);
            request.getRequestDispatcher("main_hidden.jsp").forward(request,response);

        }
        catch(Exception ex)
        {
            ex.printStackTrace();
            //error 代码
        }
    }
}
