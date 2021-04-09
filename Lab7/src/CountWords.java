import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.*;

public interface CountWords {
    static void count(BufferedReader reader, BufferedWriter writer) throws IOException {
        Map<String, Integer> comWords = CountWords.readWords(new HashMap<String, Integer>(), reader);
        reader.close();

        ArrayList<String> comWordsMax = CountWords.comWordsMaximum(comWords);

        CountWords.writeRes(comWordsMax, writer);
        writer.close();
    }

    static Map<String, Integer> readWords(HashMap<String, Integer> comWords, BufferedReader reader) throws IOException {
        String str;
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
        return comWords;
    }

    static ArrayList<String> comWordsMaximum(Map<String, Integer> comWords){
        Map<String,Integer> sortedWords = CountWords.sortByComparator(comWords, false);
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
        return comWordsMax;
    }

    static void writeRes(ArrayList<String> res, BufferedWriter writer) throws IOException {
        writer.write("Найчастіше зустрічаються: ");

        writer.newLine();
        for (String item : res) {
            writer.write(item);
            writer.newLine();
        }
    }

    static Map<String, Integer> sortByComparator(Map<String, Integer> unsortMap, final boolean order)
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
