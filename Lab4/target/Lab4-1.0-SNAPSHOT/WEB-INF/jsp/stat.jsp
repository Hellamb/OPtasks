<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
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
    <link rel="stylesheet" href="${pageContext.request.contextPath}/styles/general.css" />
    <link rel="stylesheet" href="${pageContext.request.contextPath}/styles/nav/nav.css" />
    <link rel="stylesheet" href="${pageContext.request.contextPath}/styles/stat/stat.css" />

    <title>Statistics</title>
</head>
<body>
    <jsp:include page="nav.jsp" />

    <ul class="stat">
        <c:forEach items="${requestScope.stat.entrySet()}" var="statItem">
            <li class="stat-item">${statItem.key}:
                <c:forEach items="${statItem.value}" var="valueItem" varStatus="loop">
                    <c:choose>
                        <c:when test="${loop.index == fn:length(statItem.value) - 1}">${valueItem}</c:when>
                        <c:otherwise>${valueItem}, </c:otherwise>
                    </c:choose>
                </c:forEach></li>
        </c:forEach>
    </ul>
</body>
</html>
