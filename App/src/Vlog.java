import java.util.ArrayList;

public class Vlog {
    private String author;
    ArrayList<Video> videos;

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

    public void addVideo(Video video)
    {
        this.videos.add(video);
    }

    @Override
    public String toString() {
        return "Vlog{" +
                "author='" + author + '\'' +
                ", videos=" + videos +
                '}';
    }
}
