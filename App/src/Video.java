import java.util.ArrayList;

public class Video {
    private String name;
    private final String url;
    private long views;
    private int likes;
    private int dislikes;
    private ArrayList<Comment> comments;

    Video(String name, String url)
    {
        setName(name);
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

    public void increaseViews()
    {
        views++;
    }

    public void decreaseViews()
    {
        views--;
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
        likes--;
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
        dislikes--;
    }

    public ArrayList<Comment> getComments() {
        return comments;
    }

    public void removeComment(int index)
    {
        comments.remove(index);
    }

    public void removeComment()
    {
        comments.remove(comments.size() - 1);
    }

    public void addComment(Comment comment)
    {
        comments.add(comment);
    }
}
