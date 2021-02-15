import java.util.ArrayList;
import java.util.HashSet;
import java.util.Objects;

public class Vlog {
    private String author;
    private HashSet<Video> videos = new HashSet<>();

    public Vlog(String author) throws EmptyFieldException {
        setAuthor(author);
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) throws  EmptyFieldException{
        if (author == null) throw new NullPointerException();
        if (author.length() == 0) throw new EmptyFieldException();

        this.author = author;
    }

    public void addVideo(Video vid)
    {
        this.videos.add(vid);
    }

    public HashSet<Video> getVideos()
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

    public void setVideos(HashSet<Video> videos)
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


    public HashSet<Video> getWorstVideos()
    {
       int maxDis = 0;
       HashSet<Video> worst = new HashSet<Video>();

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
