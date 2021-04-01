<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: user
  Date: 31.03.2021
  Time: 22:38
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Statistics</title>
</head>
<body>
    <jsp:include page="nav.jsp" />

    <ul class="stat">
        <c:forEach items="${requestScope.stat.entrySet()}" var="statItem">
            <li class="stat-item">${statItem.key}: <c:forEach items="${statItem.value}" var="valueItem">${valueItem}, </c:forEach></li>
        </c:forEach>
    </ul>
</body>
</html>
