<%@ page import="java.util.List" %>
<%@ page import="java.util.Enumeration" %><%--
  Created by IntelliJ IDEA.
  User: zhangzhe
  Date: 2019-03-26
  Time: 10:00
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Permission</title>
</head>
<body>
<%

    List<String> list = (List<String>) request.getAttribute("perms");
    for (String s:list){
        out.println(s);
    }
%>
</body>
</html>
