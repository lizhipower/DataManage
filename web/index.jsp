<%--
  Created by IntelliJ IDEA.
  User: ZhiLI
  Date: 2016/3/13
  Time: 14:04
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>file upload</title>
</head>
<body>
    <form action="FileUpload"
          method="post"
          enctype="multipart/form-data"
    >
        <input type="file" name="file" size="50">
        <br/>
        <input type="submit" value="doSubmit">
    </form>
</body>
</html>

