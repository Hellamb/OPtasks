<%--
  Created by IntelliJ IDEA.
  User: user
  Date: 30.03.2021
  Time: 18:43
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Update your page</title>
</head>
<body>
    <jsp:include page="nav.jsp" />
    <aside class="options">
        <c:set var="option1" value="" />
        <c:set var="option2" value="" />

        <c:choose>
            <c:when test="${param['option'] == 'video'}">
                <c:set var="option2" value="active" />
            </c:when>
            <c:otherwise>
                <c:set var="option1" value="active" />
            </c:otherwise>
        </c:choose>

        <ul class="options-list">
            <li id="settings-opt" class="option ${option1}">Settings</li>
            <li id="add-video-opt" class="option ${option2}">Post Video</li>
        </ul>
    </aside>
    <section class="content">
        <div class="option-item settings">
            <div class="settings-content">
                <form action="/pageUpdate" method="post">
                    <ul class="setting-list">
                        <li class="setting-field">Username: <input required name="setting-username" type="text"></li>
                        <li class="setting-field"><input value="Apply" type="submit"></li>
                    </ul>
                </form>
            </div>
        </div>
        <div class="option-item add-video">
            <div class="add-video-content">
                <form action="${pageContext.request.contextPath}/pageUpdate" method="post">
                    <ul class="add-video-list">
                        <li class="video-field">Name: <input required name="video-name" type="text"></li>
                        <li class="video-field">Url: <input required name="video-url" type="text"></li>
                        <li class="video-field">Poster url: <input name="video-poster-url" type="text"></li>
                        <li class="video-field"><input value="Post Video" type="submit"></li>
                    </ul>
                </form>

            </div>
        </div>
    </section>

    <script>
        window.onload = () => {
            let setting_opt = document.querySelector("#settings-opt"),
                add_video_opt = document.querySelector("#add-video-opt")

            let disableAll = (items) => {
                [...items].forEach(opt => {
                    opt.style.display = "none"
                })
            }

            let displaySettings = () => {
                disableAll(document.querySelectorAll(".content > *"))

                document.querySelector(".settings").style.display = "block"
            }

            let displayAddVideo = () => {
                disableAll(document.querySelectorAll(".content > *"))

                document.querySelector(".add-video").style.display = "block"
            }

            if (add_video_opt.classList.contains("active"))
            {
                displayAddVideo()
            }
            else
            {
                displaySettings()
            }

            setting_opt.addEventListener("click", () => {
                displaySettings()
            })

            add_video_opt.addEventListener("click", () => {
                displayAddVideo()
            })
        }
    </script>
</body>
</html>
