# 我的一个java web项目

<p align="center"><img src="http://jeff.spring4all.com/FqswykKZn-AtSIstOyuCioVxHZf4" width="30%"  alt=""/></p>

<p align="center"></p>

&emsp;&emsp;先从表白墙偷一张图，图文无关。


&emsp;&emsp;大二小学期开始了，这次课程设计的要求是开发一个Java的大作业，作业选题是各种各样的管理系统。每个队伍最多五人，而且选题不可以重复。我的选题是大学生创新项目管理系统。

&emsp;&emsp;我刷B站的时候，偶尔会刷到其他学校计算机软件专业的课程设计，我大一的时候其他985的同学就已经可以做出很精美的游戏或者技术力很高的软件，而我一个2048就得扣半天。所以我这次决定做一个好一点的项目，来总结我这两年编程的学习成果。

&emsp;&emsp;我的想法是做一个基于java web的大创项目管理系统，实现学生的注册，登录，以及大创项目的增删改查，还有一些其他的功能，下面我来总结一下：

&emsp;&emsp;首先是创建项目，没想到新建文件夹这一步还把我卡了好久，IDEA2021创建Java web项目的方式变化很大，按照洗头默认的方式创建的项目直接就404了，我很不能理解为什么，卡了整整一天之后才在网上找到了解决方法：先创建一个空项目，然后慢慢在里面添加web框架，再之后再修改配置信息。后来又遇到了很多小bug，我才写出来第一个静态主页。

![](http://image.openwrite.cn/26803_10626C0F83B34291B1C5E2C11878B54D){:class=center width='80%'}

&emsp;&emsp;我使用css的伪类实现了一些简单的动画效果，通过设定它的display属性来实现登录和注册的相互切换，然后使用qq和微信的svg实现快捷注册的功能。登陆注册页面的其他图标使用某个font库中携带的icon组件。

&emsp;&emsp;这是我的html：

```html
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
  <head>
    <title>$Title$</title>
    <link rel="stylesheet" href="css/index.css" charset="UTF-8">
    <link rel="stylesheet" href="css/font-awesome.css" charset="UTF-8">
  </head>
  <body>

  <div id="login-box">

    <h1>大学生创新项目管理系统</h1>

    <div class="nav">

      <ul id="list">
        <li class="current_li current me" onclick="change1()" id="me_1">登录</li>
        <li onclick="change2()" class="me" id="me_2">注册</li>
      </ul>

    </div>
    <form action="login" class="con_1" method="post">
      <div class="form ">
        <div class="item">
          <i class="fa fa-user-circle-o" aria-hidden="true"></i>
          <input id="xuehao" name="userId" type="text" placeholder="学号" required/>
        </div>
        <div class="item">
          <i class="fa fa-key" aria-hidden="true"></i>
          <input id="password" name="userPwd1" type="password" placeholder="密码" required/>
        </div>
      </div>
      <button type="submit" class="submit_btn">登录</button>
    </form>
    <form action="register"   class="con_2" method="post" style="display: none">
      <div class="form " >
        <div class="item">
          <i class="fa fa-user-circle-o" aria-hidden="true"></i>
          <input id="xuehao_register" name="userId" type="text" placeholder="学号" required/>
        </div>
        <div class="item">
          <i class="fa fa-user-circle-o" aria-hidden="true"></i>
          <input id="name_register" name="userName" type="password" placeholder="姓名" required/>
        </div>
        <div class="item">
          <i class="fa fa-key" aria-hidden="true"></i>
          <input id="password_register" name="userPwd1" type="password" placeholder="密码" required/>
        </div>
        <div class="item">
          <i class="fa fa-key" aria-hidden="true"></i>
          <input id="password_register_re" name="userPwd2" type="password" placeholder="重新输入密码" required/>
        </div>
      </div>
      <button type="submit" class="submit_btn">注册</button>
    </form>
    <div class="quickzone">
      <div>快捷注册</div>
      <div class="duo_logo">
        <svg xmlns="http://www.w3.org/2000/svg" class="svg-icon" viewBox="64 64 896 896" width="24" height="24"
             style="fill: rgb(92, 150, 253);">
          <path d="M824.8 613.2c-16-51.4-34.4-94.6-62.7-165.3C766.5 262.2 689.3 112 511.5 112 331.7 112 256.2 265.2 261 447.9c-28.4 70.8-46.7 113.7-62.7 165.3-34 109.5-23 154.8-14.6 155.8 18 2.2 70.1-82.4 70.1-82.4 0 49 25.2 112.9 79.8 159-26.4 8.1-85.7 29.9-71.6 53.8 11.4 19.3 196.2 12.3 249.5 6.3 53.3 6 238.1 13 249.5-6.3 14.1-23.8-45.3-45.7-71.6-53.8 54.6-46.2 79.8-110.1 79.8-159 0 0 52.1 84.6 70.1 82.4 8.5-1.1 19.5-46.4-14.5-155.8z"></path>
        </svg>
        <svg  xmlns="http://www.w3.org/2000/svg" class="svg-icon" viewBox="64 64 896 896" width="24" height="24"
              style="fill: rgb(10, 187, 7);">
          <path d="M690.1 377.4c5.9 0 11.8.2 17.6.5-24.4-128.7-158.3-227.1-319.9-227.1C209 150.8 64 271.4 64 420.2c0 81.1 43.6 154.2 111.9 203.6a21.5 21.5 0 0 1 9.1 17.6c0 2.4-.5 4.6-1.1 6.9-5.5 20.3-14.2 52.8-14.6 54.3-.7 2.6-1.7 5.2-1.7 7.9 0 5.9 4.8 10.8 10.8 10.8 2.3 0 4.2-.9 6.2-2l70.9-40.9c5.3-3.1 11-5 17.2-5 3.2 0 6.4.5 9.5 1.4 33.1 9.5 68.8 14.8 105.7 14.8 6 0 11.9-.1 17.8-.4-7.1-21-10.9-43.1-10.9-66 0-135.8 132.2-245.8 295.3-245.8zm-194.3-86.5c23.8 0 43.2 19.3 43.2 43.1s-19.3 43.1-43.2 43.1c-23.8 0-43.2-19.3-43.2-43.1s19.4-43.1 43.2-43.1zm-215.9 86.2c-23.8 0-43.2-19.3-43.2-43.1s19.3-43.1 43.2-43.1 43.2 19.3 43.2 43.1-19.4 43.1-43.2 43.1zm586.8 415.6c56.9-41.2 93.2-102 93.2-169.7 0-124-120.8-224.5-269.9-224.5-149 0-269.9 100.5-269.9 224.5S540.9 847.5 690 847.5c30.8 0 60.6-4.4 88.1-12.3 2.6-.8 5.2-1.2 7.9-1.2 5.2 0 9.9 1.6 14.3 4.1l59.1 34c1.7 1 3.3 1.7 5.2 1.7a9 9 0 0 0 6.4-2.6 9 9 0 0 0 2.6-6.4c0-2.2-.9-4.4-1.4-6.6-.3-1.2-7.6-28.3-12.2-45.3-.5-1.9-.9-3.8-.9-5.7.1-5.9 3.1-11.2 7.6-14.5zM600.2 587.2c-19.9 0-36-16.1-36-35.9 0-19.8 16.1-35.9 36-35.9s36 16.1 36 35.9c0 19.8-16.2 35.9-36 35.9zm179.9 0c-19.9 0-36-16.1-36-35.9 0-19.8 16.1-35.9 36-35.9s36 16.1 36 35.9a36.08 36.08 0 0 1-36 35.9z"></path>
        </svg>
      </div>
    </div>

  </div>

  <script src="js/index.js"></script>
  </body>

</html>
```



&emsp;&emsp;然后，我根据登录和注册的相关需求创建了各种java类。

&emsp;&emsp;以下是JDBC访问mysql数据库：

```java
import java.sql.*;
import java.util.*;

import java.sql.SQLException;

public class database {
    Connection connection = null;
    public database(String name,String password)
    {
        try {
            Class.forName("com.mysql.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        try {
            connection=DriverManager.getConnection("jdbc:mysql://localhost:3306/cippus_sys",name,password);
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }


    }
    void show()
    {
        System.out.println(this.connection);
    }
    void insert(String id,String name,String password,String userImagepath) throws SQLException {
        PreparedStatement prep=connection.prepareStatement("insert into user_stu values(?,?,?,?,?)");
        prep.setString(1,id);
        prep.setString(2,name);
        prep.setString(3,password);
        prep.setString(4,"student");
        prep.setString(5,userImagepath);
        prep.execute();
    }
    public void delete(String id,String password) throws SQLException {
        PreparedStatement prep =connection.prepareStatement("delete  from user_stu where user_id=?");
        prep.setString(1,id);
        prep.execute();
    }
    public userdata getuser(String tid) throws SQLException {
        PreparedStatement prep =connection.prepareStatement("select * from user_stu where user_id=?");
        prep.setString(1,tid);
        prep.executeQuery();
        ResultSet resultSet =prep.getResultSet();
        if(resultSet.next())
        {
            String name=resultSet.getString("user_name");
            String id =resultSet.getString("user_id");
            String password = resultSet.getString("password");
            String path =resultSet.getString("userImgPath");
            return new userdata(id,name,password,path);
        }
        else
        {
            return null;
        }
    }
    public ArrayList<userdata> getalluser() throws SQLException {
        ArrayList<userdata> temp=new ArrayList<userdata>();
        PreparedStatement prep =connection.prepareStatement("select * from user_stu ");
        prep.executeQuery();
        ResultSet resultSet =prep.getResultSet();
        while (resultSet.next())
        {
            String name=resultSet.getString("user_name");
            String id =resultSet.getString("user_id");
            String password = resultSet.getString("password");
            String path =resultSet.getString("userImgPath");
            temp.add(new userdata(id,name,password,path));
        }
        return temp;
    }
    public void close()throws SQLException
    {
        connection.close();
    }
    public boolean check(String userid,String pwd) throws SQLException {
        PreparedStatement prep =connection.prepareStatement("select * from user_stu where user_id=? and password=?");
        prep.setString(1,userid);
        prep.setString(2,pwd);
        prep.executeQuery();
        ResultSet resultSet =prep.getResultSet();
        if(resultSet.next())
        {
            return true;
        }
        else
        {
            return false;
        }
    }
}
```



&emsp;&emsp;以下是user类（存储用户的id，姓名，密码和头像的存储路径）：

```java
public class userdata {
    private String Username;
    private String Userid;
    private String UserPwd;
    private String UserImgPath;
    public userdata(String id,String name,String Pwd,String path)
    {
        this.Username=name;
        this.Userid=id;
        this.UserPwd=Pwd;
        this.UserImgPath=path;
    }

}
```



&emsp;&emsp;以下是login类，作为servlet类接收从html传来的request并且反馈response：

```java
import java.sql.SQLException;

import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
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
                printWriter.write("欢迎回来");
                response.sendRedirect("main.html?"+"id="+userid+"&pw1="+pw1);
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
```



&emsp;&emsp;以下是register类，作为servlet类接收从html传来的request并且反馈response：

```java
import java.sql.SQLException;

import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
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

                printWriter.write("恭喜注册成功");
            } catch (SQLException throwables) {
                throwables.printStackTrace();
                printWriter.write("糟糕，失败了，可能是id重复了");
            }
        }
        else
        {

            printWriter.write("两次输入密码不一致，请返回重试");

        }
    }
}
```

&emsp;&emsp;还有就是登录界面：

```html
<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2021/7/10 0010
  Time: 16:53
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
  <head>
    <title>登录</title>
    <link rel="stylesheet" href="css/index.css" charset="UTF-8">
    <link rel="stylesheet" href="css/font-awesome.css" charset="UTF-8">
  </head>
  <body>

  <div id="login-box">

    <h1>大学生创新项目管理系统</h1>

    <div class="nav">

      <ul id="list">
        <li class="current_li current me" onclick="change1()" id="me_1">登录</li>
        <li onclick="change2()" class="me" id="me_2">注册</li>
      </ul>

    </div>
    <form action="login" class="con_1" method="post">
      <div class="form ">
        <div class="item">
          <i class="fa fa-user-circle-o" aria-hidden="true"></i>
          <input id="xuehao" name="userId" type="text" placeholder="学号" required/>
        </div>
        <div class="item">
          <i class="fa fa-key" aria-hidden="true"></i>
          <input id="password" name="userPwd1" type="password" placeholder="密码" required/>
        </div>
      </div>
      <button type="submit" class="submit_btn">登录</button>
    </form>
    <form action="register"   class="con_2" method="post" style="display: none">
      <div class="form " >
        <div class="item">
          <i class="fa fa-user-circle-o" aria-hidden="true"></i>
          <input id="xuehao_register" name="userId" type="text" placeholder="学号" required/>
        </div>
        <div class="item">
          <i class="fa fa-user-circle-o" aria-hidden="true"></i>
          <input id="name_register" name="userName" type="password" placeholder="姓名" required/>
        </div>
        <div class="item">
          <i class="fa fa-key" aria-hidden="true"></i>
          <input id="password_register" name="userPwd1" type="password" placeholder="密码" required/>
        </div>
        <div class="item">
          <i class="fa fa-key" aria-hidden="true"></i>
          <input id="password_register_re" name="userPwd2" type="password" placeholder="重新输入密码" required/>
        </div>
      </div>
      <button type="submit" class="submit_btn">注册</button>
    </form>
    <div class="quickzone">
      <div>快捷注册</div>
      <div class="duo_logo">
        <svg xmlns="http://www.w3.org/2000/svg" class="svg-icon" viewBox="64 64 896 896" width="24" height="24"
             style="fill: rgb(92, 150, 253);">
          <path d="M824.8 613.2c-16-51.4-34.4-94.6-62.7-165.3C766.5 262.2 689.3 112 511.5 112 331.7 112 256.2 265.2 261 447.9c-28.4 70.8-46.7 113.7-62.7 165.3-34 109.5-23 154.8-14.6 155.8 18 2.2 70.1-82.4 70.1-82.4 0 49 25.2 112.9 79.8 159-26.4 8.1-85.7 29.9-71.6 53.8 11.4 19.3 196.2 12.3 249.5 6.3 53.3 6 238.1 13 249.5-6.3 14.1-23.8-45.3-45.7-71.6-53.8 54.6-46.2 79.8-110.1 79.8-159 0 0 52.1 84.6 70.1 82.4 8.5-1.1 19.5-46.4-14.5-155.8z"></path>
        </svg>
        <svg  xmlns="http://www.w3.org/2000/svg" class="svg-icon" viewBox="64 64 896 896" width="24" height="24"
              style="fill: rgb(10, 187, 7);">
          <path d="M690.1 377.4c5.9 0 11.8.2 17.6.5-24.4-128.7-158.3-227.1-319.9-227.1C209 150.8 64 271.4 64 420.2c0 81.1 43.6 154.2 111.9 203.6a21.5 21.5 0 0 1 9.1 17.6c0 2.4-.5 4.6-1.1 6.9-5.5 20.3-14.2 52.8-14.6 54.3-.7 2.6-1.7 5.2-1.7 7.9 0 5.9 4.8 10.8 10.8 10.8 2.3 0 4.2-.9 6.2-2l70.9-40.9c5.3-3.1 11-5 17.2-5 3.2 0 6.4.5 9.5 1.4 33.1 9.5 68.8 14.8 105.7 14.8 6 0 11.9-.1 17.8-.4-7.1-21-10.9-43.1-10.9-66 0-135.8 132.2-245.8 295.3-245.8zm-194.3-86.5c23.8 0 43.2 19.3 43.2 43.1s-19.3 43.1-43.2 43.1c-23.8 0-43.2-19.3-43.2-43.1s19.4-43.1 43.2-43.1zm-215.9 86.2c-23.8 0-43.2-19.3-43.2-43.1s19.3-43.1 43.2-43.1 43.2 19.3 43.2 43.1-19.4 43.1-43.2 43.1zm586.8 415.6c56.9-41.2 93.2-102 93.2-169.7 0-124-120.8-224.5-269.9-224.5-149 0-269.9 100.5-269.9 224.5S540.9 847.5 690 847.5c30.8 0 60.6-4.4 88.1-12.3 2.6-.8 5.2-1.2 7.9-1.2 5.2 0 9.9 1.6 14.3 4.1l59.1 34c1.7 1 3.3 1.7 5.2 1.7a9 9 0 0 0 6.4-2.6 9 9 0 0 0 2.6-6.4c0-2.2-.9-4.4-1.4-6.6-.3-1.2-7.6-28.3-12.2-45.3-.5-1.9-.9-3.8-.9-5.7.1-5.9 3.1-11.2 7.6-14.5zM600.2 587.2c-19.9 0-36-16.1-36-35.9 0-19.8 16.1-35.9 36-35.9s36 16.1 36 35.9c0 19.8-16.2 35.9-36 35.9zm179.9 0c-19.9 0-36-16.1-36-35.9 0-19.8 16.1-35.9 36-35.9s36 16.1 36 35.9a36.08 36.08 0 0 1-36 35.9z"></path>
        </svg>
      </div>
    </div>

  </div>

  <script src="js/index.js"></script>
  </body>

</html>

```

&emsp;&emsp;以及主界面：

```html
<!DOCTYPE html>
<html lang="en" xmlns:v-bind="http://www.w3.org/1999/xhtml">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <title>Login</title>
    <!-- 引入vue.js -->
    <script src="js/vue.min.js"></script>
    <!--引入vue-resource.js插件-->

    <script src="js/vue-resource.min.js"></script>
    <script src="js/vue_in_main.js"></script>
    <script src="js/main.js"></script>
    <link rel="stylesheet" href="css/main.css" charset="UTF-8">
    <link rel="stylesheet" href="css/font-awesome.css" charset="UTF-8">
</head>

<head>
    <title>个人主页</title>
</head>
<body>
<div class="upzone ">
    <div class="sch_logo">
        <img src="image/index/校徽无损.svg" style="width:200px;">
    </div>
    <div class="mytit">
        <div>
            大学生创新项目管理系统
        </div>
    </div>
    <div class="yis_zone" id="yis">
        <div class="halo">
            你好，{{project.name}}
        </div>
        <div class="head"><img class="head_img" src="image/index/head.jpg" style="width: 50px;
    height: 50px;
    border-radius: 50%;"></div>
    </div>
    <script>
        new Vue({
            el: '.yis_zone',
            data() {
                var project = a();
                return {
                    project: project,
                    count: 5
                }
            },
            methods: {},
            create() {
                alert("登录成功")
            }
        })
    </script>
</div>
<div class="left_zone">
    <div class="straight">
        <div class="menu">
            <div class="menuItem uno">我的
                <span style="line-height: 100px" id="look_mode_span">&nbsp; &nbsp; 点击这里查看自己的项目</span>
            </div>
            <div class="menuItem dos">编辑
                <span style="line-height: 100px" id="edit_mode_span">&nbsp; &nbsp; 点击这里进入编辑模式</span>
            </div>
            <div class="menuItem tres">删除
                <span style="line-height: 100px" id="del_mode_span">&nbsp; &nbsp; 删除项目，再见dlut</span></div>

        </div>
    </div>
</div>
<div class="center">
    <div class="center_zone" id="create_mode" v-if="!project.isCreate">
        <div>我觉得你应该创建一下项目</div>
        <div>
            <form method="post" action="newProject">
                <div>
                    <input v-model="project.id" name="leader" type="hidden">
                    <input value="请输入你项目的名字，建议是英文" name="project_name">
                </div>
                <button type="submit">创建</button>
            </form>
        </div>
    </div>
    <div class="center_zone " id="look_mode" v-if="project.isCreate">
        <div class="item flex"><b>项目名称:&nbsp;&nbsp;</b>{{project.Pname}}
        </div>
        <div class="item flex">
            <div>
                <b>项目成员:&nbsp;&nbsp;</b></div>
            <div>
                <table style="border-collapse:collapse">
                    <tr v-for="(item,i) in project.member">
                        <td>{{item}}</td>
                        <td>{{i==0?"队长":"队员"}}</td>
                    </tr>
                </table>
            </div>
        </div>
        <div class="item"><b>申报书:&nbsp;&nbsp;</b>{{project.book}}
        </div>
        <div class="item"><b>项目等级:&nbsp;&nbsp;</b>{{project.projectlevel}}
        </div>
        <div class="item"><b>目前的阶段:&nbsp;&nbsp;</b>{{project.stage}}</div>
    </div>
    <div class="center_zone " id="change_mode" v-if="project.isCreate">
        <form action="changeTeamName" method="post">
            <div class="item flex" v-if="!project.isowner">
                <div><b>项目名称:&nbsp;&nbsp;</b></div>
                <input v-model="project.member[0]" v-bind:name="project.namelist[0]" type="hidden">
                <input v-model="project.Pname" name="project_name">
                <div class="nbsp">
                    <button type="submit">修改名称</button>
                </div>
            </div>
            <div class="item flex" v-else>
                <div><b>项目名称:&nbsp;&nbsp;</b>{{project.Pname}}</div>
                <div class="nbsp" v-else>由于你不是队长，所以什么事情也做不了</div>
            </div>
        </form>
        <div class="item flex">
            <form action="ChangeTeamInfo" method="post">
                <div class="flex">
                    <div>
                        <b>项目成员:&nbsp;&nbsp;</b></div>
                    <div>
                        <table style="border-collapse:collapse" v-if="project.isowner">
                            <tr v-for="(item,i) in project.member">
                                <td>{{item}}</td>
                                <td>{{i==0?"队长":"队员"}}</td>
                            </tr>

                        </table>
                        <table style="border-collapse:collapse" v-else>
                            <tr v-for="index of 5">
                                <td><input v-model="project.member[index-1]" v-bind:name="project.namelist[index-1]">
                                </td>
                                <td>{{index==0?"队长":"队员"}}</td>
                            </tr>

                        </table>

                    </div>
                    <div class="nbsp" v-if="!project.isowner">
                        <button type="submit">修改队员信息(请不要修改自己，否则后果自负)</button>
                    </div>
                    <div class="nbsp" v-else>由于你不是队长，所以什么事情也做不了</div>
                </div>

            </form>
        </div>
        <div class="item flex  "><b>申报书:&nbsp;&nbsp;</b>{{project.book}}
            <div class="nbsp">重新上传</div>
        </div>
        <div class="item"><b>项目等级:&nbsp;&nbsp;</b>{{project.projectlevel}}</div>
        <div class="item"><b>目前的阶段:&nbsp;&nbsp;</b>{{project.stage}}</div>
    </div>
    <div class="center_zone " id="del_mode" v-if="project.isCreate">
        <div class="item"><b>项目名称:&nbsp;&nbsp;</b>{{project.Pname}}
        </div>
        <div class="item flex">
            <div>
                <b>项目成员:&nbsp;&nbsp;</b></div>
            <div>
                <table style="border-collapse:collapse">
                    <tr v-for="(item,i) in project.member">
                        <td>{{item}}</td>
                        <td>{{i==0?"队长":"队员"}}</td>
                    </tr>
                </table>
            </div>

        </div>
        <div class="item"><b>申报书:&nbsp;&nbsp;</b>{{project.book}}</div>
        <div class="item"><b>项目等级:&nbsp;&nbsp;</b>{{project.projectlevel}}</div>
        <div class="item"><b>目前的阶段:&nbsp;&nbsp;</b>{{project.stage}}</div>
        <div class="item flex"><b>删除项目(删除之后队伍信息会清空，你和你的队员们可以创建自己新的项目，祝一帆风顺~):&nbsp;&nbsp;</b>
        <div class="nbsp" v-if="!project.isowner">
            <form method="post" action="RemoveProject">
            <input type="hidden" v-model="project.member[0]" name="member_1" >
            <input type="hidden" v-model="project.Pname" name="project_name" >
            <button type="submit">删除项目</button>
            </form>
        </div>
        <div class="nbsp" v-else>由于你不是队长，所以不能删库跑路</div>
        </div>
    </div>
</div>

<script>
    new Vue({
        el: '.center',
        data() {
            var project = a();
            if(project.Pname!==false)
            {
                project.isCreate=true;
                console.log(project);
                project.book = "申报书.pdf"
                if (project.member[0] !== project.id) {
                    project.isowner = true;
                } else {
                    project.isowner = false;
                }
                project.namelist = ["member_1", "member_2", "member_3", "member_4", "member_5"]
                return {
                    project: project,
                    count: 5
                }
            }
            else
            {

                project.isCreate=false;
                return {
                    project: project,
                    count: 5
                }
            }


        },
        methods: {},
        beforeCreate() {
            console.log("almost got it" + this.count);
        },
        create() {
            console.log("almost got it");
            this.data()
        }
    })
</script>
<div class="footer"></div>
<div class="mask"></div>
</body>
<script src="js/main_dom.js"></script>

</html>
```

&emsp;&emsp;以及教师主界面：

```html
<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2021/7/17 0017
  Time: 20:04
  To change this template use File | Settings | File Templates.
--%>

<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<html>
<head>
    <title>Title</title>
</head>
<link rel="stylesheet" href="css/main_hidden.css" charset="UTF-8">
<link rel="stylesheet" href="css/font-awesome.css" charset="UTF-8">
<body>
<div class="mask"></div>
<div class="upzone ">
    <div class="sch_logo">
        <img src="image/index/校徽无损.svg" style="width:200px;">
    </div>
    <div class="mytit">
        <div>
            大学生创新项目管理系统——教师端
        </div>
    </div>
</div>
<div class="left_zone">
    <div class="straight">
        <div class="menu">
            <div class="menuItem uno">我的
                <span style="line-height: 100px" id="look_mode_span">&nbsp; &nbsp; 点击这里查看学生的项目</span>
            </div>
            <div class="menuItem dos">编辑
                <span style="line-height: 100px" id="edit_mode_span">&nbsp; &nbsp; 点击这里进入编辑模式</span>
            </div>
        </div>
    </div>
</div>
<div class="center">
    <div class="center_zone " id="look_mode">
    <table border="1">
        <tr>
            <td>项目id</td>
            <td>项目名称</td>
            <td>队长</td>
            <td>队员2</td>
            <td>队员3</td>
            <td>队员4</td>
            <td>队员5</td>
            <td>阶段</td>
            <td>项目等级</td>
        </tr>
        <c:forEach items="${requestScope.users}" var="user">
            <tr >
                <td>${user.id}</td>
                <td>${user.name}</td>
                <td>${user.member_1}</td>
                <td>${user.member_2}</td>
                <td>${user.member_3}</td>
                <td>${user.member_4}</td>
                <td>${user.member_5}</td>
                <td>${user.stage}</td>
                <td>${user.projectlevel}</td>
            </tr>
        </c:forEach>
    </table>
    </div>
    <div class="center_zone flex" id="change_mode" >

        <div><table border="1">
            <tr>
                <td>项目id</td>
                <td>项目名称</td>
                <td>队长</td>
                <td>阶段</td>
                <td>项目等级</td>
                <td>修改</td>
            </tr>
            <c:forEach items="${requestScope.users}" var="user">

                <tr >
                    <form class="flex" method="post" action="admin_change">
                    <td><input name='id' value=${user.id}></td>
                    <td><input name='name' value=${user.name}></td>
                    <td><input name='member_1' value=${user.member_1}></td>
                    <td><input name='stage' value=${user.stage}></td>
                    <td><input name='projectlevel' value=${user.projectlevel}></td>
                    <td><button type="submit">提交</button> </td>
                    </form>
                </tr>


            </c:forEach>
        </table></div>


    </div>
    <div>

    </div>
    <div>欢迎<%=request.getAttribute("fx")%>回来!</div>
</div>
<div class="footer"></div>

</body>
<script src="js/main_hidden_dom.js"></script>

</html>
```

下面放几张美图吧：
<p align="center"><img src="http://www.constfrost.com/media/editor/image-20210720234723901_20220304202502941669.png" width="60%"  alt=""/></p>
<p align="center"><img src="http://www.constfrost.com/media/editor/image-20210720234742244_20220304202513173316.png" width="60%"  alt=""/></p>
<p align="center"><img src="http://www.constfrost.com/media/editor/image-20210720234755292_20220304202526276540.png" width="60%"  alt=""/></p>
<p align="center"><img src="http://www.constfrost.com/media/editor/image-20210720234834776_20220304202549107080.png" width="60%"  alt=""/></p>
<p align="center"><img src="http://www.constfrost.com/media/editor/image-20210720234843187_20220304202556455916.png" width="60%"  alt=""/></p>
<p align="center"><img src="http://jeff.spring4all.com/Fkn-N7csD2tM4bkr5EelrRAFrBRI.png" width="60%"  alt=""/><br/></p>



&emsp;&emsp;目前项目已经开源了，大伙可以去看一看:[Github-科创平台管理系统](https://github.com/fangtaosong/sophomore-Java-homework "Github-科创平台管理系统")

![](/media/editor/H0K%$XKZSPLLW`HNW${EDHY_20220304202723036933.png){:class=center}
