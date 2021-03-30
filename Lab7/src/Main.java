import java.io.IOException;
import java.util.ArrayList;

public class Main {
    public static void main(String[] args) throws IOException, InterruptedException {
        ArrayList<String> input = new ArrayList<String>();
        ArrayList<String> output = new ArrayList<String>();

        for (int i=1;i<=8;i++){
            input.add("source" + i + ".txt");
            output.add("result" + i + ".txt");
        }

        oneThread(input, output);
        multiThread(input, output);
    }

    public static void oneThread(ArrayList<String> input, ArrayList<String> output) throws IOException, InterruptedException
    {
        long timeStart = System.currentTimeMillis();
        Thread onet = new Thread(new OneThread(input, output));
        onet.start();
        onet.join();
        System.out.println("Результат однопоточности расчитан за " +
                (System.currentTimeMillis()-timeStart) + " мс");

    }

    public static void multiThread(ArrayList<String> input, ArrayList<String> output) throws IOException, InterruptedException
    {
        long timeStart = System.currentTimeMillis();
        for (int i=0;i<8;i++){
            Thread t = new Thread(new MultiThread(input.get(i), output.get(i)));
            t.start();
            t.join();
        }
        System.out.println("Результат многопоточности расчитан за " +
                (System.currentTimeMillis()-timeStart) + " мс");
    }

}
