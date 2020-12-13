import java.net.MalformedURLException;

public class Main {
    public static void main(String[] args) throws MalformedURLException {
        try {
            Vlog vl1 = new Vlog("//Who//");

            Video v = new Video("Hello", "https://www.youtube.com/watch?v=xaW7SX43nuo");

            Comment com = new Comment("It's a good video");
            com.setLikes(5);
            Comment com2 = new Comment("It's a bad video");

            v.addComment(com);
            //v.addComment(com2);

            System.out.println("Task 1: " + vl1.overallViews());
            System.out.println("Task 2: " + v.isMorePopularComment());
            System.out.println("Task 3: " + vl1.getWorstVideos());

            //System.out.println(vl1.toString());

        } catch (MalformedURLException e) {
            System.out.println("Exception: Invalid url for video");
        } catch (IndexOutOfBoundsException e) {
            System.out.println("Exception: " + e.getMessage());
        }
    }

}
