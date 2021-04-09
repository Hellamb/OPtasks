import java.io.*;
import java.util.*;

public class MultiThread implements Runnable{
    BufferedReader reader;
    BufferedWriter writer;
    String name;

    public MultiThread(String inFilename, String outFilename,String name) throws IOException {
        this.reader = new BufferedReader(new FileReader(inFilename));
        this.writer = new BufferedWriter(new FileWriter(outFilename,true));
        this.name = name;
    }

    @Override
    public void run() {
        try {
            synchronized (this.writer) {
                CountWords.count(this.reader, this.writer);
                this.reader.close();
                this.writer.close();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


}
