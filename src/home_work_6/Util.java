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

    public static List<String> listFilesUsingJavaIO(String dir) {
        return Stream.of(new File(dir).listFiles())
                .filter(file -> !file.isDirectory())
                .map(File::getName)
                .collect(Collectors.toList());
    }

    public static void ls() {
        List<String> filenames = listFilesUsingJavaIO(dst);
        Collections.sort(filenames);
        Map<Integer, String> sortedMap = new LinkedHashMap<>();
        int i = 1;
        for (String name : filenames) {
            sortedMap.put(i++, name);
        }
        for (int key : sortedMap.keySet()) {
            System.out.println("[" + key + "]  " + sortedMap.get(key));
        }

        System.out.print("Enter number: ");
        Scanner scanner = new Scanner(System.in);
        Integer number = Integer.parseInt(scanner.nextLine());
        System.out.println(number);
        String filename = sortedMap.get(number);
        System.out.print("Enter word: ");
        String word = scanner.nextLine();
        BasicSearch bs = new BasicSearch();
        String doc = bs.get(String.join(File.separator, Util.dst, filename));
        int num = bs.getWordFrequency(doc, word);
        System.out.println("Occurrences: " + num);
    }

    public static void main(String[] args) {
        ls();
//        Util.generate(3);
    }
}
