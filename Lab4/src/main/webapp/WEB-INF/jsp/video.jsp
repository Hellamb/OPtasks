<%--
  Created by IntelliJ IDEA.
  User: user
  Date: 30.03.2021
  Time: 18:33
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Video Overview</title>
</head>
<body>
    <jsp:include page="nav.jsp" />

    <section class="video-content">
        <div class="video-wrapper">
            <div class="video">
                <iframe allowfullscreen src="${requestScope.video.url}?autoplay=1" frameborder="0"></iframe>
            </div>
            <div class="video-description">
                <h3 class="video-name"><c:out value="${requestScope.video.name}" /></h3>
                <form class="video-views-likes-dislikes" action="${pageContext.request.contextPath}/video" method="post">
                    <span class="video-views">${requestScope.video.views} views</span>
                    <label for="liked"><span class="video-likes">${requestScope.video.likes} likes</span></label>
                    <input id="liked" name="liked" type="submit">
                    <label for="disliked"><span class="video-dislikes">${requestScope.video.dislikes} dislikes</span></label>
                    <input id="disliked" name="disliked" type="submit">
                    <input name="video-id" value="${param['id']}" type="hidden">
                </form>
            </div>
        </div>
        <div class="comments-wrapper">
            <form class="add-comment" action="${pageContext.request.contextPath}/video" method="post">
                <input name="video-id" value="${param['id']}" type="hidden">
                <textarea required placeholder="Add some comment..." name="comment-body" cols="30" rows="10"></textarea>
                <input value="Add Comment" type="submit">
            </form>
            <div class="comments">
                <c:forEach items="${requestScope.video.comments}" var="comment">
                    <div class="comment">
                        <p class="comment-body">
                            <c:out value="${comment.text}" default="Empty body" />
                        </p>
                        <div class="statistics">
                            <span class="comment-likes">${comment.likes}</span>
                            <span class="comment-dislikes">${comment.dislikes}</span>
                            <span class="comment-author"><c:out value="${comment.author}" /> </span>
                        </div>
                    </div>
                </c:forEach>
            </div>
        </div>
    </section>
</body>
</html>
