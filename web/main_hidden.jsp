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
