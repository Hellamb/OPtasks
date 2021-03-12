<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <title>JSP - Hello World</title>
</head>
<body>
<h1><%= "Team 4 Lab 1" %></h1>
<br/>
<a href="${pageContext.request.contextPath}/hello-servlet">To Image</a>
<p><%=request.getContextPath() %></p>
</body>
</html>