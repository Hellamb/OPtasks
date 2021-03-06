package com.example.Lab1;

import java.io.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;

@WebServlet(name = "helloServlet", value = "/hello-servlet")
public class HelloServlet extends HttpServlet {
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
        response.setContentType("text/html");

        // Hello
        PrintWriter out = response.getWriter();
        out.println("<html><head></head><body>");
        out.println("<h1>Hello from HelloServlet</h1>");
        out.println("<img src = 'https://cs8.pikabu.ru/post_img/big/2016/02/04/7/145458292112119207.jpg'></br>");
        out.println("<a href = 'https://www.google.com.ua'>To Google<a></br>");
        out.println("<a href = 'KseniaPageServlet'>To Ksenia Page</a></br>");
        out.println("<a href = 'VladPageServlet'>To Vlad Page</a></br>");
        out.println("<a href = 'DimaPageServlet'>To Dima Page</a></br>");
        out.println("</body></html>");
    }

    public void destroy() {
    }
}