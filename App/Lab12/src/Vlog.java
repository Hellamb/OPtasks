import java.util.ArrayList;
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

    public int overallViews()
    {
        int allViews = 0;
        for(Video vid : videos)
        {
            allViews += vid.getViews();
        }
        return allViews;
    }


    public ArrayList<Video> getWorstVideos()
    {
       int maxDis = 0;
       ArrayList<Video> worst = new ArrayList<Video>();
       for(Video vid: videos)
       {
           if(vid.getDislikes() > maxDis) maxDis = vid.getDislikes();
       }
       for(Video vid: videos)
       {
           if(vid.getDislikes() == maxDis) worst.add(vid);
       }
       return worst;

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
