import javax.servlet.http.HttpSession;
import java.util.ArrayList;

public class VideoModel {

    Video getVideoById(String toId, Vlog vlog)
    {
        int id;

        try
        {
            id = Integer.parseInt(toId);
        }catch (NumberFormatException e)
        {
            throw new NumberFormatException("Id is not parsable");
        }

        if (vlog == null)
        {
            throw new IllegalArgumentException();
        }

        ArrayList<Video> videosList = vlog.getVideos();

        if (id < 0 || id >= videosList.size())
        {
            throw new IndexOutOfBoundsException("Id is out of bound");
        }

        return videosList.get(id);
    }

    void processLiking(Video video, Vlog vlog, boolean liked)
    {
        if (liked)
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
        }else{

            if (video.getDislikers().contains(vlog)) {
                video.getDislikers().remove(vlog);
                video.decreaseDislikes();
            } else {
                video.getDislikers().add(vlog);

                if (video.getLikers().remove(vlog)) {
                    video.decreaseLikes();
                }

                video.increaseDislikes();
            }
        }
    }
}
