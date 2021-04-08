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
            Map<String, Integer> comWords = CountWords.readWords(new HashMap<String, Integer>(), reader);
            this.reader.close();

            ArrayList<String> comWordsMax = CountWords.comWordsMaximum(comWords);

            synchronized (this.writer) {
                CountWords.writeRes(comWordsMax, this.writer);
                this.writer.close();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


}
