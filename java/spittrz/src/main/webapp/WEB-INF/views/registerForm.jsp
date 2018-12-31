<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="sf" %>
<%@ page contentType="text/html;charset=UTF-8" %>
<%@ page session="false" %>
<h1>Register</h1>

<sf:form method="post" commandName="spitter"><sf:errors path="*" element="div" cssClass="error"/>
    <p><sf:label path="firstName" cssErrorClass="error">First Name:</sf:label>
        <sf:input type="text" path="firstName" cssErrorClass="error"/></p>
    <p><sf:label path="lastName" cssErrorClass="error">Last Name:</sf:label>
        <sf:input path="lastName" type="text"/></p>
    <p><sf:label path="email" cssErrorClass="error">Email:</sf:label>
        <sf:input path="email" type="email"/></p>
    <p><sf:label path="username" cssErrorClass="error">Username:</sf:label>
        <sf:input path="username" type="text"/></p>
    <p><sf:label path="password" cssErrorClass="error">Password</sf:label>
        <sf:input path="password" type="password"/></p>
    <p><input type="submit" value="Register"/></p>
</sf:form>
