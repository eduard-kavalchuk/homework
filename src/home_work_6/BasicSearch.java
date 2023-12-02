package home_work_6;

import java.io.*;
import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class BasicSearch {
    public static final String path = String.join(File.separator, System.getProperty("user.dir"), "resources", "book.txt");
    public String get(String path) {
        StringBuilder sb = new StringBuilder();
        try (BufferedReader reader = new BufferedReader(new FileReader(path))) {
            String line;
            while ((line = reader.readLine()) != null) {
                if (line.isEmpty())
                    sb.append(" ");
                else sb.append(line);
            }
        } catch (FileNotFoundException e){
            throw new RuntimeException("Файл не найден.");
        } catch (IOException e) {
            throw new RuntimeException("Ошибка чтения файла: " + e.getMessage());
        }
        return sb.toString();
    }

    public int getUniqueWordsNumber(String doc) {
        Stream<String> stream = Arrays.stream(doc.split( "\\s+" ));
        Set<String> set = new HashSet<>();
        stream.forEach(set::add);
        return set.size();
    }

    public int getWordCount(String doc, String word) {
        Map<String, Integer> map =  getMostFrequentWords(doc);
        try {
            return map.get(word);
        } catch (NullPointerException e) {
            return 0;
        }
    }

    public void printMostUsedWords(String doc, int N) {
        Map<String, Integer> unsortedMap = getMostFrequentWords(doc);
        System.out.println("Всего уникальных слов: " + unsortedMap.size());
        LinkedHashMap<String, Integer> sortedMap = unsortedMap.entrySet()
                .stream()
                .sorted(Map.Entry.comparingByValue(Comparator.reverseOrder()))
                .collect(Collectors.toMap(
                        Map.Entry::getKey,
                        Map.Entry::getValue,
                        (oldValue, newValue) -> oldValue, LinkedHashMap::new));

        int counter = 0;
        for (String key : sortedMap.keySet()) {
            if (counter++ > N) break;
            System.out.println(key + "  " + sortedMap.get(key));
        }
    }

    public Map<String, Integer> getMostFrequentWords(String doc) {
        Map<String, Integer> map = new HashMap<>();
        Stream<String> stream = Arrays.stream(doc.split( "\\s+" ));
        final Integer[] e = new Integer[1];
        stream.forEach(entry -> map.put(entry, (e[0] = map.get(entry)) == null ? 1 : e[0] + 1));
        return map;
    }
}
