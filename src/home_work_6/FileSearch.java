package home_work_6;

import java.io.*;
import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * 7. Написать новый класс с точкой входа. При запуске программы пользователь должен передать адрес папки,
 * из которой мы будет считывать текстовые файлы. Наполнить данную директорию книгами, 100 книг мнинимум.
 * При запуске пользователю в консоль выдать список txt файлов и предложить выбрать файл, с которым мы будем работать.
 * Пользователь, выбрав файл вводит то, что он хочет найти в этом файле. После каждого ввода осуществляется поиск.
 * Вводит пока не надоест. Пользователь может вернуться к выбору файла. Результат всех его поисков должен
 * накапливаться в файла result.txt в формате «Имя файла – слово – количество». Тестируем.
 * */
public class FileSearch {
    public static String src = String.join(File.separator, System.getProperty("user.dir"), "resources", "book.txt");
    public static String dst = String.join(File.separator, System.getProperty("user.dir"), "resources", "books");
    public static String result = String.join(File.separator, System.getProperty("user.dir"), "resources", "result.txt");

    /**
     * Copy {@code n_lines} from file {@code src} to file {@code dest} starting from line number {@code start}
     * */
    public static void copyFile(String src, String dest, int start, int n_lines) {
        String line;
        int i = 0;
        try (BufferedReader reader = new BufferedReader(new FileReader(src));
             BufferedWriter writer = new BufferedWriter(new FileWriter(dest))) {
            while ((line = reader.readLine()) != null && i < start + n_lines) {
                if (++i < start) continue;
                writer.write(line + "\n");
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    /**
     * Generate {@code n_books} text files
     * */
    private static void generate(int n_books) {
        for (int i = 1; i < n_books; i++) {
            String dst = String.join(File.separator, FileSearch.dst, i + ".txt");
            copyFile(FileSearch.src, dst, 100 * i, 100);
        }
    }

    /**
     * Search words in files from {@code directory}
     * */
    public static void fileSearch(String directory) {
        // Выполнить обход директории и показать список файлов
        BasicSearch bs = new BasicSearch();
        Map<Integer, String> sortedMap = new LinkedHashMap<>();
        int i = 1;

        List<String> filenames = Stream.of(Objects.requireNonNull(new File(directory).listFiles()))
                .filter(file -> !file.isDirectory())
                .map(File::getName).sorted().toList();
        for (String name : filenames) {
            sortedMap.put(i++, name);
        }
        for (int key : sortedMap.keySet()) {
            System.out.println("[" + key + "]  " + sortedMap.get(key));
        }

        // Поиск слов в файлах
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(result))) {
            while (true) {
                String doc;
                String filename;
                System.out.print("Введите порядковый номер книги (любой другой ввод для прекращения): ");
                Scanner scanner = new Scanner(System.in);
                try {
                    int bookNumber = Integer.parseInt(scanner.nextLine());
                    filename = sortedMap.get(bookNumber);
                    doc = bs.get(String.join(File.separator, FileSearch.dst, filename));
                } catch (NumberFormatException e) {
                    break;
                }

                while (true) {
                    System.out.print("Введите слово для поиска (пустой ввод для прекращения): ");
                    String keyword = scanner.nextLine();
                    if (keyword.isEmpty()) break;
                    int entries = bs.getWordFrequency(doc, keyword);
                    System.out.println("Найдено: " + entries);
                    writer.write(filename + " - " + keyword + " - " + entries + "\n");
                }
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public static void main(String[] args) {
        fileSearch(dst);
    }
}
