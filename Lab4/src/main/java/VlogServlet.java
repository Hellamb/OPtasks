import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebServlet(name = "VlogServlet", value = "")
public class VlogServlet extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        HttpSession session = request.getSession();

        if (session.getAttribute("vlog") == null)
        {
            session.setAttribute("vlog", new Vlog("Username"));
        }

        getServletContext().getRequestDispatcher("/WEB-INF/jsp/vlog.jsp").forward(request, response);
    }
}
