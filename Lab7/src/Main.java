import java.io.IOException;
import java.util.ArrayList;

public class Main {
    public static void main(String[] args) throws IOException, InterruptedException {
        ArrayList<String> input = new ArrayList<String>();
        String output = "result.txt";
        String outputMulti = "result_multi.txt";

        for (int i=1;i<=8;i++){
            input.add("source" + i + ".txt");
        }

        oneThread(input, output);
        multiThread(input, outputMulti);
    }

    public static void oneThread(ArrayList<String> input, String output) throws IOException, InterruptedException
    {
        long timeStart = System.currentTimeMillis();
        Thread onet = new Thread(new OneThread(input, output));
        onet.start();
        onet.join();
        System.out.println("Результат однопоточности расчитан за " +
                (System.currentTimeMillis()-timeStart) + " мс");

    }

    public static void multiThread(ArrayList<String> input, String output) throws IOException, InterruptedException
    {
        long timeStart = System.currentTimeMillis();
        for (int i=0;i<8;i++){
            Thread t = new Thread(new MultiThread(input.get(i), output));
            t.start();
            t.join();
        }
        System.out.println("Результат многопоточности расчитан за " +
                (System.currentTimeMillis()-timeStart) + " мс");
    }

}
