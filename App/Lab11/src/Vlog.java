import java.util.Objects;
import java.util.TreeSet;

public class Vlog {
    private String author;
    private VideoComparator vcomp = new VideoComparator();
    private TreeSet<Video> videos = new TreeSet<Video>(vcomp);
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
    public TreeSet<Video> getVideos()
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

    public void setVideos(TreeSet<Video> videos)
    {
        this.videos = videos;
    }

    public long overallViews()
    {
        Iterator<Video> iter = videos.iterator();
        long views = 0;

        while(iter.hasNext())
        {
            Video video = iter.next();
            views += video.getViews();
        }

        return views;
    }


    public TreeSet<Video> getWorstVideos()
    {
        TreeSet<Video> worstVideos = new TreeSet<Video>(vcomp);
        Iterator<Video> itr = videos.iterator();
        boolean stop = false;
        Video element1 = itr.next();
        worstVideos.add(element1);

        while (itr.hasNext() && element1.compareTo(itr.next())==0)
        {
            element1 = itr.next();
            element1 = itr.previous();
            worstVideos.add(element1);
        }
        return worstVideos;
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
