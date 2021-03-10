package com.example.Lab1;

import java.io.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;

@WebServlet(name = "KseniaPage", value = "/KseniaPageServlet")
public class KseniaPageServlet extends HttpServlet {
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
        response.setContentType("text/html");

        // Hello
        PrintWriter out = response.getWriter();
        out.println("<html><head></head><body>");
        out.println("<h1>Hello from KseniaPageServlet</h1>");
        out.println("<img src = 'Images/KseniaPhoto.jpg'></br>");
        out.println("<a href = 'VladPageServlet'>To Vlad Page</a></br>");
        out.println("<a href = 'DimaPageServlet'>To Dima Page</a></br>");
        out.println("</body></html>");
    }

    public void destroy() {
    }
}