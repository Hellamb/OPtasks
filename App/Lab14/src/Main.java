import java.io.IOException;

public class Main {
    public static void main(String[] args) throws IOException {
        String source = "source.txt";
        String destination = "destination.txt";
        Task4 task4 = new Task4();
        task4.copeToUpperCase(source, destination);
    }
}
