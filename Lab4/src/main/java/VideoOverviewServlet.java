import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Map;

@WebServlet(name = "VideoOverviewServlet", value = "/video")
public class VideoOverviewServlet extends HttpServlet {
    VideoModel model = new VideoModel();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Map<String, String[]> params = request.getParameterMap();

        if (!params.containsKey("id"))
        {
            response.sendError(400, "Id is not specified!");
            return;
        }
        HttpSession session = request.getSession();

        Vlog vlog = (Vlog) session.getAttribute("vlog");

        Video video;

        try
        {
            video = model.getVideoById(params.get("id")[0], vlog);
        }catch (NumberFormatException e)
        {
            response.sendError(400, e.getMessage());
            return;
        }catch (IllegalArgumentException e)
        {
            response.sendRedirect("/");
            return;
        }catch (IndexOutOfBoundsException e)
        {
            response.sendError(400, e.getMessage());
            return;
        }

        if (!video.getViewers().contains(vlog))
        {
            video.increaseViews();
            video.getViewers().add(vlog);
        }

        request.setAttribute("video", video);

        getServletContext().getRequestDispatcher("/WEB-INF/jsp/video.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Map<String, String[]> params = request.getParameterMap();

        if (!params.containsKey("video-id"))
        {
            response.sendError(400, "Id is required");
            return;
        }

        HttpSession session = request.getSession();

        Vlog vlog = (Vlog) session.getAttribute("vlog");

        Video video;

        try
        {
            video = model.getVideoById(params.get("video-id")[0], vlog);
        }catch (IllegalArgumentException e)
        {
            response.sendRedirect("/");
            return;
        }catch (IndexOutOfBoundsException e)
        {
            response.sendError(400, e.getMessage());
            return;
        }

        //comments manipulations
        if (params.containsKey("comment-body"))
        {
            video.addComment(new Comment(vlog.getAuthor(), params.get("comment-body")[0]));
        }
        //Likes/dislikes processing
        else if (params.containsKey("liked"))
        {
            model.processLiking(video, vlog, true);
        }else if (params.containsKey("disliked")) {
            model.processLiking(video, vlog, false);
        }
        //else return error
        else
        {
            response.sendError(400);
        }


        response.sendRedirect("/video?id=" + params.get("video-id")[0]);
    }
}
