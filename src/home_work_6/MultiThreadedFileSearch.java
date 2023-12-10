package home_work_6;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.concurrent.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * 8. Написать новый класс с точкой входа. При запуске программы пользователь должен передать адрес папки, из которой мы будет считывать текстовые файлы. После запуска пользователь указывает что он хочет найти в этих текстах. После каждого ввода осуществляется поиск. Вводит пока не надоест. Поиск выполняется многопоточно. Один файл – одно задание для поиска. Задания помещаются в ExecutorService. Результат всех его поисков должен накапливаться в файла result.txt в формате «Имя файла – слово – количество».
 * После заверщение обработки всех книг вывести записанные результаты в файла result.txt;
 * Тестируем
 * */
public class MultiThreadedFileSearch implements Callable<String> {
    private final String filename;
    private final String keyword;

    public MultiThreadedFileSearch(String filename, String keyword) {
        this.filename = filename;
        this.keyword = keyword;
    }

    public String call() {
        BasicSearch bs = new BasicSearch();
        String currentDir = System.getProperty("user.dir");
        Path path = Paths.get(currentDir, "resources", "books", filename);
        String doc = bs.get(path.toString());
        int entries = bs.getWordFrequency(doc, keyword);

        return filename + " - " + keyword + " - " + entries + "\n";
    }

    /**
     * List files in a directory.
     * @param dir Path to directory
     * @return Set containing paths to found files
     * */
    public static Set<String> listFiles(String dir) {
        return Stream.of(new File(dir).listFiles())
                .filter(file -> !file.isDirectory())
                .map(File::getName)
                .collect(Collectors.toSet());
    }

    /**
     * Performs multithreaded search in text file.
     * @param pathToDir Path to directory containing files
     * @param pathToOutputFile Path to output file to store results of search
     * @param keyword Keyword to search by
     * */
    public static void doSearch(String pathToDir, String pathToOutputFile, String keyword) {
        List<Callable<String>> tasks = new ArrayList<>();
        List<Future<String>> results;
        StringBuilder builder = new StringBuilder();
        int nTheads = 2;  // number of threads to spawn

        for (String filename : listFiles(pathToDir)) {
            tasks.add(new MultiThreadedFileSearch(filename, keyword));
        }

        try (ExecutorService exec = Executors.newFixedThreadPool(nTheads)) {
            results = exec.invokeAll(tasks);
            exec.shutdown();
            for (Future<String> future : results) {
                builder.append(future.get());
            }
        } catch (Exception e) {
            throw new RuntimeException();
        }

        try (BufferedWriter writer = new BufferedWriter(new FileWriter(pathToOutputFile))) {
            writer.write(builder.toString());
        } catch (IOException e) {
            throw new RuntimeException();
        }
    }
}
