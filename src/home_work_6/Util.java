package home_work_6;

import java.io.*;
import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Util {
    public static String src = String.join(File.separator, System.getProperty("user.dir"), "resources", "book.txt");
    public static String dst = String.join(File.separator, System.getProperty("user.dir"), "resources", "books");

    public static void copyFile(String src, String dest, int start, int n_lines) {
        try (BufferedReader reader = new BufferedReader(new FileReader(src));
             BufferedWriter writer = new BufferedWriter(new FileWriter(dest))) {
            String line;
            int i = 0;
            while ((line = reader.readLine()) != null && i < start + n_lines) {
                if (++i < start) continue;
                writer.write(line + "\n");
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public static void generate(int n_books) {
        for (int i = 1; i < n_books; i++) {
            String dst = String.join(File.separator, Util.dst, i + ".txt");
            copyFile(Util.src, dst, 100 * i, 100);
        }
    }

    public static void ls() {
        List<String> filenames = Stream.of(new File(dst).listFiles())
                .filter(file -> !file.isDirectory())
                .map(File::getName)
                .collect(Collectors.toList());;
        Collections.sort(filenames);
        Map<Integer, String> sortedMap = new LinkedHashMap<>();
        int i = 1;
        for (String name : filenames) {
            sortedMap.put(i++, name);
        }
        for (int key : sortedMap.keySet()) {
            System.out.println("[" + key + "]  " + sortedMap.get(key));
        }

        Integer bookNumber;
        String filename;
        String keyword;
        BasicSearch bs = new BasicSearch();
        String doc;
        while (true) {
            System.out.print("Введите порядковый номер книги (любой другой ввод для прекращения): ");
            Scanner scanner = new Scanner(System.in);
            try {
                bookNumber = Integer.parseInt(scanner.nextLine());
            } catch (NumberFormatException e) {
                break;
            }
            System.out.println(bookNumber);
            try {
                filename = sortedMap.get(bookNumber);
                doc = bs.get(String.join(File.separator, Util.dst, filename));
            } catch (NullPointerException e) {
                break;
            }

            while (true) {
                System.out.print("Введите слово для поиска (пустой ввод для прекращения): ");
                keyword = scanner.nextLine();
                if (keyword.isEmpty()) break;
                System.out.println("Найдено: " + bs.getWordFrequency(doc, keyword));
            }
        }
    }

    public static void main(String[] args) {
        ls();
    }
}
