import java.io.*;
import java.util.*;

public class OneThread implements Runnable{
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
        String str;
        Map<String, Integer> comWords = new HashMap<String, Integer>();

        while ((str = reader.readLine()) != null){
            String[] words = str.split(" ");
            for (int i = 0; i < words.length;i++){
                if (comWords.containsKey(words[i])){
                    int tmp = comWords.get(words[i]);
                    comWords.put(words[i], tmp + 1);
                }
                else{
                    comWords.put(words[i],1);
                }
            }
        }
        reader.close();

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

        BufferedWriter writer = new BufferedWriter(new FileWriter(outFilename,true));
        writer.write("Найчастіше зустрічаються: ");

        writer.newLine();
        for (String item : comWordsMax) {
            writer.write(item);
            writer.newLine();
        }
        writer.close();

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
