<%--
  Created by IntelliJ IDEA.
  User: user
  Date: 30.03.2021
  Time: 17:21
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/styles/general.css" />
    <link rel="stylesheet" href="${pageContext.request.contextPath}/styles/nav/nav.css" />
    <link rel="stylesheet" href="${pageContext.request.contextPath}/styles/vlog/vlog.css" />

    <title>Vlog</title>
</head>
<body>
    <jsp:include page="nav.jsp" />

    <section class="content-wrapper">
            <c:choose>
                <c:when test="${sessionScope.containsKey('vlog') && !sessionScope['vlog'].videos.isEmpty()}">
                    <div class="videos">
                        <c:forEach items="${sessionScope['vlog'].videos}" var="video" varStatus="loop">
                            <div class="video" data-id="${loop.index}">
                                <div class="video-poster"><img src="<c:out value="${video.getPosterUrl()}" />" alt="poster"></div>
                                <div class="video-description"><span><c:out value="${video.getName()}" /></span></div>
                            </div>
                        </c:forEach>
                    </div>
                </c:when>
                <c:otherwise>
                    <h1 class="no-video">There is no videos yet! Please, click "Add Video" to add some content</h1>
                </c:otherwise>
            </c:choose>

        <div class="add-video">
            <button><a href="${pageContext.request.contextPath}/pageUpdate?option=video">Add Video</a></button>
        </div>
    </section>

    <script>
        window.onload = () => {
            [...document.querySelectorAll(".video")].forEach(video => {
                video.addEventListener("click", () => {
                    window.location.href = "/video?id=" + video.dataset.id
                })
            })
        }
    </script>
</body>
</html>
