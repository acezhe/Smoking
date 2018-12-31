    <%@ page contentType="text/html; charset=utf-8" session="false" %>
        <%@ taglib uri="http://www.springframework.org/tags" prefix="s" %>
        <%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="t" %>
        <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
        <html>
        <head>
        <title>Spittrz</title>
            <link rel="stylesheet"
            type="text/css"
            href="<s:url value="/resources/style.css" />" >
        </head>
        <body>
        <div id="header">
        <t:insertAttribute name="header"/>
        </div>
        <div id="content">
        <t:insertAttribute name="body"/>
        </div>
        <div id="footer">
        <t:insertAttribute name="footer"/>
        </div>
        </body>
        </html>