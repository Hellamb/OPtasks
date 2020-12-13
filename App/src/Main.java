import java.net.MalformedURLException;

public class Main {
    public static void main(String[] args) {
        try
        {
            Comment com = new Comment("It's a good video");
            Comment com2 = new Comment("It's a bad video");
            Video v1 = new Video("Hello", "https://www.youtube.com/watch?v=xaW7SX43nuo");
            v1.addComment(com);
            v1.removeComment(com);
            Vlog vl1 = new Vlog("//Who//");
            vl1.addVideo(v1);
            vl1.addVideo(v1);
            System.out.println(v1.toString());
            //System.out.println(vl1.toString());
        }catch (MalformedURLException e)
        {
            System.out.println("Exception: Invalid url for video");
        }catch (IndexOutOfBoundsException e)
        {
            System.out.println("Exception: " + e.getMessage());
        }
    }
}
