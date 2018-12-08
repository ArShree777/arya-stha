<%-- 
    Document   : index.jsp
    Created on : Dec 8, 2018, 5:40:52 PM
    Author     : aryas
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1>Skills</h1>
        <c:forEach var="skill" items="${requestScope.skill}">
            <h2>${skill.name}</h2>
    </c:forEach>
    </body>
</html>
