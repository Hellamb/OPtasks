import java.util.Objects;

public class Comment {
    private final String text;
    private final String author;
    private long likes;
    private long dislikes;

    public Comment(String author, String text){
        this.author = author;
        this.text = text;
        this.likes = 0;
        this.dislikes = 0;
    }

    public String getText() {
        return text;
    }

    public String getAuthor() {
        return author;
    }

    public long getLikes() {
        return likes;
    }

    public void increaseLike() {
        this.likes++;
    }

    public void decreaseLike() {
        if (this.likes != 0)
            this.likes --;
    }


    public void increaseDislike() {
        this.dislikes ++;

    }

    public void decreaseDislike() {
        if (this.dislikes != 0)
            this.dislikes --;
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
        return "Comment: {" +
                "Text: " + text + ", " +
                likes + " likes, " +
                dislikes + " dislikes}" + '\n';
    }
}
