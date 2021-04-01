public class Comment {
    private final String text;
    private final String author;

    public Comment(String author, String text){
        this.author = author;
        this.text = text;
    }

    public String getText() {
        return text;
    }

    public String getAuthor() {
        return author;
    }

    @Override
    public String toString() {
        return "Comment: {" +
                "Text: " + text + ", ";
    }
}
