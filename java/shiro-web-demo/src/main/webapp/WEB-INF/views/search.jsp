<%--
  Created by IntelliJ IDEA.
  User: zhangzhe
  Date: 2019-03-26
  Time: 09:53
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>search</title>
</head>
<body>
<%
    String baseUrl = request.getContextPath();
%>
<a href="<%=baseUrl%>/search/role">我的角色</a>
<a href="<%=baseUrl%>/search/permission">权限</a>
</body>
</html>
