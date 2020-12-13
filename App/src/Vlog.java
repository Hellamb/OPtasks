import java.util.ArrayList;
import java.util.Objects;

public class Vlog {
    private String author;
    private ArrayList<Video> videos = new ArrayList<Video>();

    public Vlog(String author)
    {
        this.author = author;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public void addVideo(Video vid)
    {
        this.videos.add(vid);
    }

    public ArrayList<Video> getVideos()
    {
        return videos;
    }

    public void removeVideo(Video vid)
    {
        videos.removeIf(video -> (video.equals(vid)));
    }

    public void setVideos(ArrayList<Video> videos)
    {
        this.videos = videos;
    }

    @Override
    public String toString() {
        return "Vlog{" +
                "author='" + author + '\'' +
                ", videos=" + videos +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Vlog vlog = (Vlog) o;
        return Objects.equals(author, vlog.author) &&
                Objects.equals(videos, vlog.videos);
    }

    @Override
    public int hashCode() {
        return Objects.hash(author, videos);
    }
}
