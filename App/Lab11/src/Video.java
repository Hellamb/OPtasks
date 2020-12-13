import java.net.MalformedURLException;
import java.net.URL;
import java.util.Objects;
import java.util.TreeSet;

public class Video {
    private String name;
    private final String url;
    private long views;
    private int likes;
    private int dislikes;
    private TreeSet<Comment> comments = new TreeSet<>();

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

    public TreeSet<Comment> getComments() {
        return comments;
    }

    public void removeComment(int index)
    {
        if (comments.size() != 0) comments.remove(index);
        else throw new IndexOutOfBoundsException("List of comments is empty");
    }

    public void removeComment()
    {
        if (comments.size() != 0) comments.remove(comments.size() - 1);
        else throw new IndexOutOfBoundsException("List of comments is empty");
    }

    public void removeComment(Comment o)
    {
        if (!comments.remove(o)) throw new IndexOutOfBoundsException("Video " + name + " does not contain a comment");
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
        boolean eqCom = true;
        for (int i = 0; i < comments.size(); i++)
        {
            if (!comments.get(i).equals(((Video) o).comments.get(i)))
            {
                eqCom = false;
                break;
            }
        }

        return views == video.views &&
                likes == video.likes &&
                dislikes == video.dislikes &&
                Objects.equals(name, video.name) &&
                Objects.equals(url, video.url) &&
                eqCom;
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, url, views, likes, dislikes, comments);
    }

    @Override
    public String toString() {
        return "Video{" +
                "name='" + name + '\'' +
                ", url='" + url + '\'' +
                ", views=" + views +
                ", likes=" + likes +
                ", dislikes=" + dislikes +
                ", comments=" + comments +
                '}'+"\n";
    }
}
