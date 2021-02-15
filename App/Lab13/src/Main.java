import java.net.MalformedURLException;

public class Main {
    public static void main(String[] args) throws MalformedURLException {
        try {
            Video vid1 = new Video("Hello", "https://www.youtube.com/Hello");
            Video vid2 = new Video("Hi", "https://www.youtube.com/Hi");
            Vlog vlog1 = new Vlog("Toma");
            Vlog vlog2 = new Vlog("Roma");
            Website web1 = new Website("Host");
            Comment com1 = new Comment("Good");
            Comment com2 = new Comment("Bad");

            vid1.setViews(4);

            com1.increaseLike();
            vid2.increaseDislikes();
            web1.addVlog(vlog1);
            web1.addVlog(vlog2);
            vlog1.addVideo(vid1);
            vlog1.addVideo(vid1);
            vlog2.addVideo(vid2);
            vid1.addComment(com2);
            vid2.addComment(com1);

            System.out.println(web1.findVlogByAuthor("Roma"));
            System.out.println("Чи є  комент популярніший за відео?: " + vid2.isMorePopularComment());
            System.out.println("Всього переглядів: " + vlog1.overallViews());
            System.out.println("Найгірші відео: " + vlog2.getWorstVideos());
        }catch (MalformedURLException e)
        {
            System.out.println("Exception: " + e.getMessage());
        }catch (IndexOutOfBoundsException e)
        {
            System.out.println("Exception: " + e.getMessage());
        }catch (EmptyFieldException e)
        {
            System.out.println("Exception: " + e.getMessage());
        }
    }

}
