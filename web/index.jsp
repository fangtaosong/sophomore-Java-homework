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
