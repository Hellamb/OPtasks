import java.net.MalformedURLException;
import java.net.URL;
import java.util.HashSet;
import java.util.Objects;

public class Video {
    private String name;
    private final String url;
    private long views;
    private int likes;
    private int dislikes;
    private HashSet<Comment> comments = new HashSet<>();

    Video(String name, String url) throws MalformedURLException {
        setName(name);

        URL u = new URL(url);

        this.url = url;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getUrl() {
        return url;
    }

    public long getViews() {
        return views;
    }

    public void setViews(long views)
    {
        this.views = views > 0 ? views : 0;
    }

    public void increaseViews()
    {
        views++;
    }

    public int getLikes() {
        return likes;
    }

    public void increaseLikes()
    {
        likes++;
    }

    public void decreaseLikes()
    {
        likes = likes > 0 ? likes - 1 : 0;
    }

    public int getDislikes() {
        return dislikes;
    }

    public void increaseDislikes()
    {
        dislikes++;
    }

    public void decreaseDislikes()
    {
        dislikes = dislikes > 0 ? dislikes - 1 : 0;
    }

    public HashSet<Comment> getComments() {
        return comments;
    }

    public void removeComment(Comment o)
    {
        if(comments.contains(o))
        {
            comments.remove(o);
        }
        else throw new IndexOutOfBoundsException("Video " + name + "does not contain comment");
    }

    public void addComment(Comment comment)
    {
        comments.add(comment);
    }

    public boolean isMorePopularComment()
    {
        for( Comment com : comments)
        {
            if (com.getLikes() > this.likes) return true;
        }
        return false;
    }



    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Video video = (Video) o;
        return views == video.views &&
                likes == video.likes &&
                dislikes == video.dislikes &&
                Objects.equals(name, video.name) &&
                Objects.equals(url, video.url) &&
                Objects.equals(comments, video.comments);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, url, views, likes, dislikes, comments);
    }

    @Override
    public String toString() {
        return "Video{" +
                "name='" + name +
                ", url='" + url  +
                ", views=" + views +
                ", likes=" + likes +
                ", dislikes=" + dislikes +
                ", comments=" + comments +
                '}';
    }
}
