<%--
  Created by IntelliJ IDEA.
  User: user
  Date: 14.03.2021
  Time: 21:29
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <link type="text/css" rel="stylesheet" href="${pageContext.request.contextPath}/styles/solution.css"/>

    <link rel="preconnect" href="https://fonts.gstatic.com">
    <link href="https://fonts.googleapis.com/css2?family=Open+Sans:wght@600&display=swap" rel="stylesheet">

    <title>Result</title>
</head>
<body>
    <div class="wrapper">
        <div class="result-content">
            <h1 class="result-header">Result of calculations:</h1>
            <ul class="result-items">
                <li class="result-item"><span class="equation-description"><span>Equation:</span><img src="${pageContext.request.contextPath}/images/equation<c:out value="${param.get('equation')}" />.png" alt="equation"></span></li>
                <li class="result-item">Parameters: <i><c:out value="a=${param.get('a')}" />, <c:out value="b=${param.get('b')}" />, <c:out value="c=${param.get('c')}" />, <c:out value="d=${param.get('d')}" /></i></li>
                <li class="result-item">Result: <i>${requestScope.result}</i></li>
            </ul>
        </div>
    </div>
</body>
</html>
