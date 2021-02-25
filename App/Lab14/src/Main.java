import java.io.IOException;

public class Main {
    public static void main(String[] args) {
        try {
            Task10 ttt = new Task10();
            ttt.split("my.txt","our",10);
            Task4 task4 = new Task4();
            task4.copeToUpperCase("source.txt", "destination.txt");
        }
        catch (IOException err)
        {
            System.out.println(err.getMessage());
        }
    }
}

