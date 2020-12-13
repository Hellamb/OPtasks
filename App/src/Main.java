public class Main {
    public static void main(String[] args) {
        Video v1 = new Video("Hello", "https://www.youtube.com/watch?v=xaW7SX43nuo");
        Vlog vl1 = new Vlog("//Who//");
        vl1.addVideo(v1);
        vl1.addVideo(v1);
        System.out.println(v1.toString());
        System.out.println(vl1.toString());

    }
}
