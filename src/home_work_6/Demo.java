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

            // Replace with a builder pattern!
//            line = sb.toString().replaceAll("\\s+[^a-zA-Z]+\\s+", " ");
//            line = sb.toString().replaceAll(PUNCTUATION_MARKS, " ");
//            line = line.replaceAll(HYPHEN, " ");
//            line = line.replaceAll(HYPHEN, " ");
//            line = line.replaceAll("[0-9]-", " ");
//            line = line.replaceAll("\\s+[0-9]+\\s+", " ");
//            line = line.replaceAll(" - ", " ");
//            line = line.replaceAll("\\s{2,}", " ");
            return sb.toString();
        } catch (FileNotFoundException e){
            throw new RuntimeException("Файл не найден.");
        } catch (IOException e) {
            throw new RuntimeException("Ошибка чтения файла: " + e.getMessage());
        }
    }

    public static void main(String[] args) {
        String s = "Источник: Издательство: 4-x Захаров, 2007 г. Твердый переплет, 800 стр. ISBN   978-5-8159-0748-5 Тираж: 5000 экз.";
        String[] array = s.split(" ");
        StringBuilder sb = new StringBuilder();
        for (String str : array) {
            for (int i = 0; i < str.length(); i++) {
                if (Character.UnicodeBlock.of(str.charAt(i)).equals(Character.UnicodeBlock.CYRILLIC)) {
                    sb.append(str);
                    sb.append(" ");
                    break;
                }
            }
        }

        System.out.println(sb.toString());

    }
}
