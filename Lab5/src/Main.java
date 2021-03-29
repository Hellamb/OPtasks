import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        try {
            Task ttt = new Task();
            ArrayList<String> result = ttt.commonestWords("source.txt");
            BufferedWriter writer = new BufferedWriter(new FileWriter("output.txt"));
            //writer.
            writer.write("Найчастіше зустрічаються:");
            writer.newLine();
            for (String item: result){
                writer.write(item);
                writer.newLine();
            }
            writer.close();
        }
        catch (IOException err)
        {
            System.out.println(err.getMessage());
        }
    }
}
