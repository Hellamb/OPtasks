import java.io.*;

public class Task4 {
    void copeToUpperCase(String source,String destination) throws IOException {
        BufferedReader reader = new BufferedReader(new FileReader(source));
        BufferedWriter writer = new BufferedWriter(new FileWriter(destination));
        String str;
        while ((str = reader.readLine()) != null){
            String strUpper = str.toUpperCase();
            writer.write(strUpper);
            writer.newLine();
        }
        reader.close();
        writer.close();
    }
}
