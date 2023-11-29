package home_work_6;

import java.io.*;
import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Demo {
    private static final String PUNCTUATION_MARKS = "[.,;:!?\'\"]";
    private static final String path = String.join(File.separator, System.getProperty("user.dir"), "resources", "book.txt");
    public static String file2String(String path) {
        StringBuilder sb = new StringBuilder();

        try (BufferedReader reader = new BufferedReader(new FileReader(path))) {
            String line;
            while ((line = reader.readLine()) != null) {
                if (line.isEmpty())
                    sb.append(" ");
                else sb.append(line
                        .replaceAll("\\s[^\\p{L}]+\\s", " ")  // убрать все слова где нет букв (любого алфавита)
                        .replaceAll(PUNCTUATION_MARKS, " "));       // убрать знаки пунктуации
            }
        } catch (FileNotFoundException e){
            throw new RuntimeException("Файл не найден.");
        } catch (IOException e) {
            throw new RuntimeException("Ошибка чтения файла: " + e.getMessage());
        }

        return sb.toString();
    }

    public static int getUniqueWordsNumber() {
        Stream<String> stream = Arrays.stream(file2String(path).split( "\\s+" ));
        Set<String> set = new HashSet<>();
        stream.forEach(set::add);
        return set.size();
    }

    public static void printMostUsedWords(int N) {
        Map<String, Integer> unsortedMap = getMostFrequentWords();
        System.out.println(unsortedMap.size());
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

    public static Map<String, Integer> getMostFrequentWords() {
        Map<String, Integer> map = new HashMap<>();
        Stream<String> stream = Arrays.stream(file2String(path).split( "\\s+" ));
        final Integer[] e = new Integer[1];
        stream.forEach(entry -> map.put(entry, (e[0] = map.get(entry)) == null ? 1 : e[0] + 1));
        return map;
    }
}
