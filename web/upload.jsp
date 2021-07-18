<%@ page language="java" pageEncoding="UTF-8"%>
<!DOCTYPE HTML>
<html>
<head>
    <title>文件上传</title>
</head>

<body>
<form action="${pageContext.request.contextPath}/servlet/UploadHandleServlet" enctype="multipart/form-data" method="post">
    上传用户：<input type="text" name="username"><br/>
    上传文件1：<input type="file" name="file1"><br/>
    上传文件2：<input type="file" name="file2"><br/>
    <input type="submit" value="提交">
</form>
</body>
</html>