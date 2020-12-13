import java.util.ArrayList;
import java.util.ListIterator;
import java.util.Objects;

public class Vlog {
    private String author;
    private ArrayList<Video> videos = new ArrayList<>();

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
        if(videos.contains(vid))
        {
            videos.remove(vid);
        }
        else throw new IndexOutOfBoundsException("Vlog " + author + "does not contain video");
    }

    public void setVideos(ArrayList<Video> videos)
    {
        this.videos = videos;
    }

    public long overallViews()
    {
        return 0;
    }


    public ArrayList<Video> getWorstVideos(){
       return null;
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
