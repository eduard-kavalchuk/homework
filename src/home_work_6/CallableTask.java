package home_work_6;

import java.io.File;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class CallableTask implements Callable<String> {
    private final String filename;
    private final String keyword;

    public CallableTask(String filename, String keyword) {
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

    public static Set<String> listFiles(String dir) {
        return Stream.of(new File(dir).listFiles())
                .filter(file -> !file.isDirectory())
                .map(File::getName)
                .collect(Collectors.toSet());
    }

    public static void main(String[] args) throws Exception {
        String currentDir = System.getProperty("user.dir");
        Path dir = Paths.get(currentDir, "resources", "books");
        for (String filename : listFiles(dir.toString())) {
            System.out.println(filename);
        }

//        List<Callable<String>> tasks = new ArrayList<>();
//        List<Future<String>> results;
//
//        // Реализовать обход директории и поместить в очередь найденные файлы
//        for (int i = 0; i < 5; i++) {
//            tasks.add(new CallableTask("test" + (i + 1) + ".txt"));
//        }
//
//        try (ExecutorService exec = Executors.newFixedThreadPool(2)) {
//            results = exec.invokeAll(tasks);
//            exec.shutdown();
//            System.out.println("Result:");
//            StringBuilder builder = new StringBuilder();
//            for (Future<String> future : results) {
//                builder.append(future.get());
//            }
//            System.out.println(builder);
//        }
    }
}
