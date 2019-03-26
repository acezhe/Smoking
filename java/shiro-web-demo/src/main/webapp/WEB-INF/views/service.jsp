<%--
  Created by IntelliJ IDEA.
  User: zhangzhe
  Date: 2019-03-26
  Time: 09:55
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>services</title>
</head>
<body>
<%
    String baseUrl = request.getContextPath();
%>
<a href="<%=baseUrl%>/service/watchMovie">看电影</a>
<a href="<%=baseUrl%>/service/playCard">打牌</a>
</body>
</html>
