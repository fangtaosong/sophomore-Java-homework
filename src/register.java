

import java.sql.SQLException;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(name = "register", value = "/register")
public class register extends HttpServlet{
    protected void doPost(HttpServletRequest request,HttpServletResponse response) throws IOException {
        PrintWriter printWriter=response.getWriter();

        request.setCharacterEncoding("utf-8");
        response.setCharacterEncoding("utf-8");
        response.setHeader("content-type","text/html;charset=utf-8");
        String name=request.getParameter("userName");
        String id=request.getParameter("userId");
        String pw1=request.getParameter("userPwd1");
        String pw2=request.getParameter("userPwd2");
        if(pw1.equals(pw2))
        {
            database database=new database("root","123456");
            try {
                database.insert(id,name,pw1,"abcde");
                database.close();

                printWriter.write("success");
                response.sendRedirect("index.jsp");
            } catch (SQLException throwables) {
                throwables.printStackTrace();
                printWriter.write("error");
            }
        }
        else
        {

            printWriter.write("两次输入密码不一致，请返回重试");

        }
    }
}
