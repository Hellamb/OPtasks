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
        Map<String, Integer> comWords = CountWords.readWords(new HashMap<String, Integer>(), reader);
        reader.close();

        ArrayList<String> comWordsMax = CountWords.comWordsMaximum(comWords);

        BufferedWriter writer = new BufferedWriter(new FileWriter(outFilename,true));
        CountWords.writeRes(comWordsMax, writer);
        writer.close();

    }

}
