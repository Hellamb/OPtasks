import java.util.Objects;

public class Comment {
    private final String text;
    private long likes;
    private long dislikes;

    public Comment(String text, long likes, long dislikes){
        this.text = text;
        this.likes = likes;
        this.dislikes = dislikes;
    }

    public String getText() {
        return text;
    }

    public long getLikes() {
        return likes;
    }

    public void addLike() {
        this.likes ++;
    }

    public void removeLike() {
        if (this.likes != 0)
            this.likes --;
    }

    public void addDislike() {
        this.dislikes = this.dislikes + 1;
    }

    public void removeDislike() {
        if (this.dislikes != 0)
            this.dislikes = this.dislikes - 1;
    }

    public void setLikes(long likes) {
        this.likes = likes;
    }

    public long getDislikes() {
        return dislikes;
    }

    public void setDislikes(long dislikes) {
        this.dislikes = dislikes;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Comment comment = (Comment) o;
        return likes == comment.likes &&
                dislikes == comment.dislikes &&
                Objects.equals(text, comment.text);
    }

    @Override
    public String toString() {
        return "Comment: " + '\n' +
                "Text: " + text + '\n' +
                likes + " likes" + '\n' +
                dislikes + "dislikes" + '\n';
    }
}
