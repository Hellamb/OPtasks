<%--
  Created by IntelliJ IDEA.
  User: user
  Date: 14.03.2021
  Time: 15:45
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page import="java.util.Date" contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <link type="text/css" rel="stylesheet" href="${pageContext.request.contextPath}/styles/index.css"/>

    <%-- Fonts--%>
    <link rel="preconnect" href="https://fonts.gstatic.com">
    <link href="https://fonts.googleapis.com/css2?family=Open+Sans:wght@600&display=swap" rel="stylesheet">

    <%! Date today = new Date(); %>
    <title>Equations <%=today.toString()%></title>
</head>
<body>
    <div class="content">
        <form action="#" class="form" method="post">
            <div class="inputs">
                <div class="parameters">
                    <input name="a" value="<c:out value="${param.get('a')}" default="${cookie['parameterA'].value}" />" required placeholder="a"/>
                    <input name="b" value="<c:out value="${param.get('b')}" default="${cookie['parameterB'].value}" />" required placeholder="b"/>
                    <input name="c" value="<c:out value="${param.get('c')}" default="${cookie['parameterC'].value}" />" required placeholder="c"/>
                    <input name="d" value="<c:out value="${param.get('d')}" default="${cookie['parameterD'].value}" />" required placeholder="d"/>
                </div>
                <div class="equation">
                    <c:set var="checked1" value=""/>
                    <c:set var="checked2" value=""/>
                    <c:set var="checked3" value=""/>

                    <c:choose>
                        <c:when test="${param.containsKey('equation')}">
                            <c:choose>
                                <c:when test='${param.get("equation") == "2"}'>
                                    <c:set var="checked2" value="checked"/>
                                </c:when>
                                <c:when test='${param.get("equation") == "3"}'>
                                    <c:set var="checked3" value="checked"/>
                                </c:when>
                                <c:otherwise>
                                    <c:set var="checked1" value="checked"/>
                                </c:otherwise>
                            </c:choose>
                        </c:when>
                        <c:otherwise>
                            <c:choose>
                                <c:when test='${cookie["nEquation"].value == "2"}'>
                                    <c:set var="checked2" value="checked"/>
                                </c:when>
                                <c:when test='${cookie["nEquation"].value == "3"}'>
                                    <c:set var="checked3" value="checked"/>
                                </c:when>
                                <c:otherwise>
                                    <c:set var="checked1" value="checked"/>
                                </c:otherwise>
                            </c:choose>
                        </c:otherwise>
                    </c:choose>

                    <label for="first">
                        <input id="first" ${checked1} name="equation" value="1" type="radio" />
                        <span>First equation</span>
                    </label>
                    <label for="second">
                        <input id="second" ${checked2} name="equation" value="2" type="radio" />
                        <span>Second equation</span>
                    </label>
                    <label for="third">
                        <input id="third" ${checked3} name="equation" value="3" type="radio" />
                        <span>Third equation</span>
                    </label>
                </div>
                <div class="submit">
                    <input value="Solve" type="submit" />
                </div>
            </div>
        </form>

        <% if (request.getSession().getAttribute("parameters") != null)
        {
        %>
            <table class="data-display">
                <tr>
                    <th>№</th>
                    <th>a</th>
                    <th>b</th>
                    <th>c</th>
                    <th>d</th>
                    <th>equation</th>
                    <th>solution</th>
                </tr>

                <c:forEach varStatus="loop" var="row" items="${sessionScope['parameters']}">
                    <tr>
                        <td>${loop.index}</td>
                        <td><c:out value="${row.get('a')}" /></td>
                        <td><c:out value="${row.get('b')}" /></td>
                        <td><c:out value="${row.get('c')}" /></td>
                        <td><c:out value="${row.get('d')}" /></td>
                        <td><c:out value="${row.get('equation')}"/></td>
                        <td><c:out value="${row.get('result')}" /></td>
                    </tr>
                </c:forEach>
            </table>
        <%} %>
    </div>
</body>
</html>
