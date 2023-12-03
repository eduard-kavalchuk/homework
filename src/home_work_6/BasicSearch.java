package home_work_6;

import java.io.*;
import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class BasicSearch {
    public static final String path = String.join(File.separator, System.getProperty("user.dir"), "resources", "book.txt");

    // Считывает файл и возвращает его содержимое в виде строки
    // Если файл не найден, то считает, что путь -- это и есть строка
    public String get(String path) {
        StringBuilder sb = new StringBuilder();
        try (BufferedReader reader = new BufferedReader(new FileReader(path))) {
            String line;
            while ((line = reader.readLine()) != null) {
                if (!line.isEmpty()) {
                    sb.append(" ");
                    sb.append(line);
                }
            }
        } catch (Exception e) {
            return path;  // считаем, что это не путь к файлу, а строка
        }
        return sb.toString();
    }

    // Возвращает количество уникальных слов в строке
    public int getUniqueWordsCount(String doc) {
        Stream<String> stream = Arrays.stream(doc.split( "\\s+" ));
        Set<String> set = new HashSet<>();
        stream.forEach(set::add);
        return set.size();
    }

    // Возвращает сколько раз слово встречается в тексте
    public int getWordFrequency(String doc, String word) {
        Map<String, Integer> map =  getUniqueWordsMap(doc);
        try {
            return map.get(word);
        } catch (NullPointerException e) {
            return 0;
        }
    }

    // Печатает N наиболее частых слов в тексте
    public void printMostUsedWords(String doc, int N) {
        Map<String, Integer> unsortedMap = getUniqueWordsMap(doc);
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
            if (key.charAt(0) == 'я' || key.charAt(0) == 'Я')
                System.out.println(key + "  " + sortedMap.get(key));
        }
    }

    // Helper method. Returns a map in which a key is a word and a value is a number of
    // occurrences of this word in text
    private Map<String, Integer> getUniqueWordsMap(String doc) {
        Map<String, Integer> map = new HashMap<>();
        Stream<String> stream = Arrays.stream(doc.split( "\\s+" ));
        final Integer[] e = new Integer[1];
        stream.forEach(entry -> map.put(entry, (e[0] = map.get(entry)) == null ? 1 : e[0] + 1));
        return map;
    }
}
