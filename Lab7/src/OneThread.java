import java.io.*;
import java.util.*;

public class OneThread implements Runnable, CountWords{
    ArrayList<String> input = new ArrayList<String>();
    String output;

    OneThread(ArrayList<String> input, String output){
        this.input = input;
        this.output = output;
    }
    @Override
    public void run() {
        for(int i = 0;i< input.size();i++){
            try {
                commonestWords(input.get(i), output);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    private void commonestWords(String inFilename, String outFilename) throws IOException {
        BufferedReader reader = new BufferedReader(new FileReader(inFilename));
        BufferedWriter writer = new BufferedWriter(new FileWriter(outFilename,true));

        CountWords.count(reader,writer);
    }

}
