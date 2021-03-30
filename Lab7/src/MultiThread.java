import java.io.*;
import java.util.*;

public class MultiThread implements Runnable{
    BufferedReader reader;
    BufferedWriter writer;

    public MultiThread(String inFilename, String outFilename) throws IOException {
        this.reader = new BufferedReader(new FileReader(inFilename));
        this.writer = new BufferedWriter(new FileWriter(outFilename));
    }

    @Override
    public void run() {
        String str;
        Map<String, Integer> comWords = new HashMap<String, Integer>();

        try {
            synchronized (reader) {
                while ((str = reader.readLine()) != null) {
                    String[] words = str.split(" ");
                    for (int i = 0; i < words.length; i++) {
                        if (comWords.containsKey(words[i])) {
                            int tmp = comWords.get(words[i]);
                            comWords.put(words[i], tmp + 1);
                        } else {
                            comWords.put(words[i], 1);
                        }
                    }
                }
                this.reader.close();
            }

            Map<String,Integer> sortedWords = sortByComparator(comWords, false);
            Integer v = 0;
            ArrayList<String> comWordsMax = new ArrayList<String>();
            for (Map.Entry<String, Integer> entry : sortedWords.entrySet())
            {
                //System.out.println(entry.getKey() + " " + entry.getValue());
                if ((v == 0) || v == entry.getValue()) {
                    v = entry.getValue();
                    comWordsMax.add(entry.getKey());
                }
            }

            synchronized (writer) {
                this.writer.write("Найчастіше зустрічаються: ");

                this.writer.newLine();
                for (String item : comWordsMax) {
                    this.writer.write(item);
                    this.writer.newLine();
                }
                this.writer.close();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static Map<String, Integer> sortByComparator(Map<String, Integer> unsortMap, final boolean order)
    {

        List<Map.Entry<String, Integer>> list = new LinkedList<Map.Entry<String, Integer>>(unsortMap.entrySet());

        // Sorting the list based on values
        Collections.sort(list, new Comparator<Map.Entry<String, Integer>>()
        {
            public int compare(Map.Entry<String, Integer> o1,
                               Map.Entry<String, Integer> o2)
            {
                if (order)
                {
                    return o1.getValue().compareTo(o2.getValue());
                }
                else
                {
                    return o2.getValue().compareTo(o1.getValue());

                }
            }
        });

        Map<String, Integer> sortedMap = new LinkedHashMap<String, Integer>();
        for (Map.Entry<String, Integer> entry : list)
        {
            sortedMap.put(entry.getKey(), entry.getValue());
        }

        return sortedMap;
    }
}
