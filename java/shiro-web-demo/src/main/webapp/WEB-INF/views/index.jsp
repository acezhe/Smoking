<%@ page contentType="text/html;charset=UTF-8" %>
<html>
<body>
<%
    String baseUrl = request.getContextPath();
%>
<h2>Hello World!</h2>
<a href="<%=baseUrl%>/loginPage">登录</a>
<a href="<%=baseUrl%>/service">服务</a>
<a href="<%=baseUrl%>/search">查询</a>
</body>
</html>
