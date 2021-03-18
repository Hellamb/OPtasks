import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

import static javax.servlet.RequestDispatcher.*;

@WebServlet(urlPatterns = "/errorHandler")
public class ErrorHandlerServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.sendRedirect("/");
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        if (req.getAttribute(ERROR_STATUS_CODE) == null)
        {
            resp.sendRedirect("/");
            return;
        }

        resp.setContentType("text/html; charset=utf-8");
        try (PrintWriter writer = resp.getWriter()) {
            writer.write("<html><head><title>Error description</title></head><body>");
            writer.write("<h2>Error description</h2>");
            writer.write("<ul>");
                writer.write("<li>Status code: "+ req.getAttribute(ERROR_STATUS_CODE) +"</li>");
                writer.write(req.getAttribute(ERROR_MESSAGE) != "" ? "<li>Error Message: "+ req.getAttribute(ERROR_MESSAGE) +"</li>" : "");
            writer.write("</ul>");
            writer.write("</html></body>");
        }
    }
}
