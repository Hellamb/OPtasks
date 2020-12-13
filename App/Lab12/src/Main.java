import java.net.MalformedURLException;

public class Main {
    public static void main(String[] args) throws MalformedURLException {
        Video vid = new Video("123", "https://www.youtube.com/watch?v=xaW7SX43nuo");
        Vlog vl1 = new Vlog("Toma");
        Website w1 = new Website("Host");
        w1.addVlog(vl1);
        System.out.println(w1.findVlogByAuthor("Toma"));
    }

}
