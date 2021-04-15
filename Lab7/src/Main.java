import java.io.*;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.function.Consumer;

public class Main {
    public static void main(String[] args)
            throws IOException, InterruptedException
    {
        ArrayList<String> input = formArrayList(new ArrayList<String>());
        String output = "result.txt";
        String outputMulti = "result_multi.txt";

        clearOutput(output, outputMulti);

        oneThread(input, output);
        multiThread(input, outputMulti);
    }

    public static void clearOutput(String output, String outputMulti)
            throws IOException
    {
        BufferedWriter writer1 = new BufferedWriter(new FileWriter(output));
        BufferedWriter writer2 = new BufferedWriter(new FileWriter(outputMulti));
        writer1.close();
        writer2.close();
    }

    public static ArrayList<String> formArrayList(ArrayList<String> list)
    {
        for (int i=1;i<=8;i++){
            list.add("source" + i + ".txt");
        }
        return list;
    }

    public static void oneThread(ArrayList<String> input, String output)
            throws IOException, InterruptedException
    {
        long timeStart = System.currentTimeMillis();
        Thread onet = new Thread(new OneThread(input, output));
        onet.start();
        onet.join();
        System.out.println("Результат однопоточности расчитан за " +
                (System.currentTimeMillis()-timeStart) + " мс");

    }

    public static void multiThread(ArrayList<String> input, String output)
            throws IOException, InterruptedException
    {
        LinkedList<Thread> list = new LinkedList<>();
        long timeStart = System.currentTimeMillis();
        for (int i=0;i<8;i++)
        {
            String name = "Thread" + i;
            Thread t = new Thread(new MultiThread(input.get(i), output, name));
            list.add(t);
            t.start();
        }
        for (Thread t : list)
        {
            t.join();
        }
        System.out.println("Результат многопоточности расчитан за " +
                (System.currentTimeMillis()-timeStart) + " мс");
    }

}
