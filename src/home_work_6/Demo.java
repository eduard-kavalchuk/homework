package home_work_6;

import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
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

            return sb.toString();

        } catch (FileNotFoundException e){
            throw new RuntimeException("Файл не найден.");
        } catch (IOException e) {
            throw new RuntimeException("Ошибка чтения файла: " + e.getMessage());
        }
    }

    public static void main(String[] args) {
        String s = file2String(path);
        s = s.substring(100, 500);
        Stream<String> stream = Arrays.stream(s.split( "\\s+" ));
        stream.forEach(System.out::println);

    }
}
