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
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Map<String, String[]> params = request.getParameterMap();

        if (!params.containsKey("id"))
        {
            response.sendError(400, "Id is not specified!");
            return;
        }

        int id;

        try
        {
            id = Integer.parseInt(params.get("id")[0]);
        }catch (NumberFormatException e)
        {
            response.sendError(400, "Invalid id!");
            return;
        }
        HttpSession session = request.getSession();

        Vlog vlog = (Vlog) session.getAttribute("vlog");

        if (vlog == null)
        {
            response.sendRedirect("/");
            return;
        }

        ArrayList<Video> videosList = vlog.getVideos();

        if (id < 0 || id >= videosList.size())
        {
            response.sendError(400, "Id is out of bounds!");
            return;
        }

        Video video = videosList.get(id);

        if (!video.getViewers().contains(vlog))
        {
            video.increaseViews();
            video.getViewers().add(vlog);
        }

        request.setAttribute("video", videosList.get(id));

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

        int id;

        try
        {
            id = Integer.parseInt(params.get("video-id")[0]);
        }catch (Exception e)
        {
            response.sendError(400, "Invalid id!");
            return;
        }
        HttpSession session = request.getSession();

        Vlog vlog = (Vlog) session.getAttribute("vlog");

        if (vlog == null)
        {
            response.sendError(400, "Vlog is not created!");
            return;
        }

        if (id < 0 || id >= vlog.getVideos().size())
        {
            response.sendError(400, "Id is out of bounds!");
            return;
        }

        Video video = vlog.getVideos().get(id);

        //comments manipulations
        if (params.containsKey("comment-body"))
        {
            video.addComment(new Comment(vlog.getAuthor(), params.get("comment-body")[0]));
        }
        //Likes/dislikes processing
        else if (params.containsKey("liked"))
        {
            if (video.getLikers().contains(vlog))
            {
                video.getLikers().remove(vlog);
                video.decreaseLikes();
            }else
            {
                video.getLikers().add(vlog);

                if (video.getDislikers().remove(vlog))
                {
                    video.decreaseDislikes();
                }

                video.increaseLikes();
            }
        }else if (params.containsKey("disliked"))
        {
            if (video.getDislikers().contains(vlog))
            {
                video.getDislikers().remove(vlog);
                video.decreaseDislikes();
            }else
            {
                video.getDislikers().add(vlog);

                if (video.getLikers().remove(vlog))
                {
                    video.decreaseLikes();
                }

                video.increaseDislikes();
            }
        //else return error
        }else
        {
            response.sendError(400);
        }


        response.sendRedirect("/video?id=" + id);
    }
}
