import java.util.Comparator;
import java.util.Objects;

public class VideoComparator implements Comparator<Video> {
    public int compare(Video v1, Video v2)
    {
        if (v1.getDislikes() > v2.getDislikes())
            return 1;
        else if (v1.getDislikes() == v2.getDislikes())
            return 0;
        else
            return -1;
    }
}