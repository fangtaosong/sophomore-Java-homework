

import java.sql.SQLException;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(name = "login", value = "/login")
public class login extends HttpServlet{
    protected void doPost(HttpServletRequest request,HttpServletResponse response) throws IOException {
        PrintWriter printWriter=response.getWriter();

        request.setCharacterEncoding("utf-8");
        response.setCharacterEncoding("utf-8");
        response.setHeader("content-type","text/html;charset=utf-8");
        String userid=request.getParameter("userId");
        String pw1=request.getParameter("userPwd1");
        System.out.println(userid+" "+pw1);
        database database=new database("root","123456");
        try {
            if(database.check(userid,pw1))
            {
//                response.sendRedirect("main.html?"+"id="+userid+"&pw1="+pw1);
                printWriter.write("欢迎回来");
                project_item p=database.search(userid);
                String Stemp=p.getinfo();
                System.out.println(p.getinfo());
                if(Stemp.equals("&notFound"))
                {
                    response.sendRedirect("main.html?"+"id="+userid+"&name="+userid+"&pw1="+pw1+"&isNew=yes");

                }
                else
                {
                    System.out.println(Stemp);
                    response.sendRedirect("main.html?"+"id="+userid+"&name="+userid+"&pw1="+pw1+Stemp);

                }

            }
            else
            {

                printWriter.write("登录失败，账号或者密码错了，请返回重试");

            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }
}
