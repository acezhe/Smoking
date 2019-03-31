<%@ page import="java.util.List" %>
<%@ page import="java.util.Enumeration" %>
<%@ page import="javax.print.StreamPrintService" %>
<%@ page import="java.util.Map" %><%--
  Created by IntelliJ IDEA.
  User: zhangzhe
  Date: 2019-03-26
  Time: 09:59
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Roles</title>
</head>
<body>
<%
   Map<String,List> map = (Map) request.getAttribute("roles");
   List<String> list = map.get("roles");
   for(String s:list){
       out.println(s);
   }
%>
</body>
</html>
