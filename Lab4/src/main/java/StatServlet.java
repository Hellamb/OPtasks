import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.Map;
import java.util.stream.LongStream;

@WebServlet(name = "StatServlet", value = "/stat")
public class StatServlet extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession();

        Vlog vlog = (Vlog) session.getAttribute("vlog");

        if (vlog == null)
        {
            response.sendRedirect("/");
            return;
        }

        request.setAttribute("stat", Map.of("Most disliked videos", vlog.getWorstVideos().stream().map(Video::getName).toArray(), "Views on vlog",  new long[] {vlog.overallViews()}));

        getServletContext().getRequestDispatcher("/WEB-INF/jsp/stat.jsp").forward(request, response);
    }
}
