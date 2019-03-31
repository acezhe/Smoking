<%@ page import="java.util.Enumeration" %><%--
  Created by IntelliJ IDEA.
  User: zhangzhe
  Date: 2019-03-26
  Time: 16:44
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>login</title>
</head>
<body>
<%
    String baseUrl = request.getContextPath();
    Enumeration<String> keys = session.getAttributeNames();
    while (keys.hasMoreElements()){
        String key = keys.nextElement();
        out.println(key);
        out.println(session.getAttribute(key));
    }
%>
<%
    out.print(request.getAttribute("shiroLoginFailure"));
%>
<form action="<%=baseUrl%>/loginPage" method="post">
    <label for="username">用户名：</label>
    <input type="text" id="username" name="username"/>
    <label for="password">密码：</label>
    <input type="password" name="password" id="password"/>
    <input type="submit" value="提交"/>
    <input type="reset" value="重置吧"/>
</form>
</body>
</html>
