package com.example.Lab1;

import java.io.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;

@WebServlet(name = "DimaPage", value = "/DimaPageServlet")
public class DimaPageServlet extends HttpServlet {
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
        response.setContentType("text/html");

        // Hello
        PrintWriter out = response.getWriter();
        out.println("<html><head></head><body>");
        out.println("<h1>Hello from DimaPageServlet</h1>");
        out.println("<img src = 'Images/DimaPhoto.jpg'></br>");
        out.println("<a href = 'KseniaPageServlet'>To Ksenia Page</a></br>");
        out.println("<a href = 'VladPageServlet'>To Vlad Page</a></br>");
        out.println("</body></html>");
    }

    public void destroy() {
    }
}