import java.io.*;

public class Task4 {
    void copeToUpperCase(String source,String destination) throws IOException {
        BufferedReader reader = new BufferedReader(new FileReader(source));
        String str = reader.readLine();
        String strUpper = str.toUpperCase();
        reader.close();

        BufferedWriter writer = new BufferedWriter(new FileWriter(destination));
        writer.write(strUpper);
        writer.close();
    }
}
