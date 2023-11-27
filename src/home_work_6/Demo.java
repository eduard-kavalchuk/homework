package home_work_6;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class Demo {
    private static final String PUNCTUATION_MARKS = "[.,;:!?\'\"]";
    private static final String HYPHEN = " -- ";
    public static String file2String() {
        String path = String.join(File.separator, System.getProperty("user.dir"), "resources", "book.txt");
        StringBuilder sb = new StringBuilder();
        String line;

        try (BufferedReader reader = new BufferedReader(new FileReader(path))) {
            while ((line = reader.readLine()) != null){
                if (line.isEmpty())
                    sb.append(" ");
                else sb.append(line);
            }
            line = sb.toString().replaceAll(PUNCTUATION_MARKS, " ");
            line = line.replaceAll(HYPHEN, " ");
            line = line.replaceAll("\\s+[0-9]+\\s+", " ");
            line = line.replaceAll(" - ", " ");
            line = line.replaceAll("\\s{2,}", " ");
            return line;
        } catch (FileNotFoundException e){
            throw new RuntimeException("Файл не найден.");
        } catch (IOException e) {
            throw new RuntimeException("Ошибка чтения файла: " + e.getMessage());
        }
    }

    public static void main(String[] args) throws IOException {
        String s = file2String();
        System.out.println(s.substring(0, 1000));


    }
}
