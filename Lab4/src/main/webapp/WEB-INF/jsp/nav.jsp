<%--
  Created by IntelliJ IDEA.
  User: user
  Date: 30.03.2021
  Time: 18:34
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>

<nav class="main-nav">
    <ul class="nav-content">
        <li class="nav-item"><a href="/">Video list</a></li>
        <li class="nav-item"><a href="/pageUpdate"><c:out value="${sessionScope['vlog'].author}" default="Signed out" /> </a></li>
        <li class="nav-item"><a href="/stat">Watch statistics</a></li>
    </ul>
</nav>
