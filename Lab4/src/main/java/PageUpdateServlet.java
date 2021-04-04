import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.net.MalformedURLException;
import java.util.ArrayList;
import java.util.Map;

@WebServlet(name = "PageUpdateServlet", value = "/pageUpdate")
public class PageUpdateServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession();

        if (session.getAttribute("vlog") == null) {
            response.sendRedirect("/");
            return;
        }

        getServletContext().getRequestDispatcher("/WEB-INF/jsp/pageUpdate.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Map<String, String[]> params = request.getParameterMap();

        Vlog vlog = (Vlog) request.getSession().getAttribute("vlog");

        //If vlog is not set then we redirect to main page to authorize
        if (vlog == null)
        {
            response.sendError(400, "Vlog is not created");
            return;
        }

        //Process each parameter
        if (params.containsKey("video-name") && params.containsKey("video-url") && params.containsKey("video-poster-url"))
        {
            try
            {
                vlog.addVideo(new Video(request.getParameter("video-name"),
                        request.getParameter("video-url"),
                        request.getParameter("video-poster-url")));
            }catch (MalformedURLException e)
            {
                response.sendRedirect("/pageUpdate");
                return;
            }
        }
        else if (params.containsKey("setting-username"))
        {
            vlog.setAuthor(request.getParameter("setting-username"));
        }else
        {
            response.sendError(400);
            return;
        }

        response.sendRedirect("/");
    }
}
