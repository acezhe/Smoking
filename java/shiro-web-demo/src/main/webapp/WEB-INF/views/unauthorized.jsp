<%--
  Created by IntelliJ IDEA.
  User: zhangzhe
  Date: 19-3-26
  Time: 下午10:33
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>unauthorized</title>
</head>
<body>
<%
    String baseUrl = request.getContextPath();
%>
没有权限
<a href="<%=baseUrl%>/logout">登出</a>
</body>
</html>
