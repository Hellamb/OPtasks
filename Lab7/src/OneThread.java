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
                CountWords.count(new BufferedReader(new FileReader(input.get(i))),
                        new BufferedWriter(new FileWriter(output,true)));
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

}
