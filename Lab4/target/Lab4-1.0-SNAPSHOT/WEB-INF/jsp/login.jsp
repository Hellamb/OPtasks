<%--
  Created by IntelliJ IDEA.
  User: user
  Date: 26.03.2021
  Time: 21:46
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/styles/general.css" />
    <link rel="stylesheet" href="${pageContext.request.contextPath}/styles/login/login.css" />
    <title>Authorization</title>
</head>
<body>
    <section class="login-wrapper">
        <div class="switch-wrapper">
            <input checked id="login-switch-1" name="form-type" type="radio" />
            <label for="login-switch-1">Sign in</label>
            <input id="login-switch-2" name="form-type" type="radio" />
            <label for="login-switch-2">Sign up</label>
        </div>

        <form class="login" action="">
            <div class="sign-in switch-selected">
                <h1 class="form-header">Sign in</h1>
                <input type="text" placeholder="username" />
                <input type="email" placeholder="email" />
                <input type="submit" />
            </div>
            <div class="sign-up">
                <h1 class="form-header">Sign up</h1>
                <input type="text" placeholder="username" />
                <input type="email" placeholder="email" />
                <input type="password" placeholder="password" />
                <input type="submit" />
            </div>
        </form>
    </section>

    <script>
        window.onload = () => {
            let sign_in_switch = document.querySelector("label[for=login-switch-1]")
            let sign_in = document.querySelector(".sign-in")
            let sign_up_switch = document.querySelector("label[for=login-switch-2]")
            let sign_up = document.querySelector(".sign-up")

            sign_in_switch.addEventListener("click", () => {
                sign_in.classList.add("switch-selected")
                sign_up.classList.remove("switch-selected")
            })
            sign_up_switch.addEventListener("click", () => {
                sign_up.classList.add("switch-selected")
                sign_in.classList.remove("switch-selected")
            })
        }

    </script>
</body>
</html>
