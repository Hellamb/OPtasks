import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        try {
            Task task = new Task();
            task.complete("source.txt","output.txt");
        }
        catch (IOException err)
        {
            System.out.println(err.getMessage());
        }
    }
}
