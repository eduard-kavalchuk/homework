package home_work_6;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.nio.file.Paths;

import static org.junit.jupiter.api.Assertions.*;

public class MultiThreadedSearchTest {
    String currentDir = System.getProperty("user.dir");
    String dir = Paths.get(currentDir, "resources", "books").toString();
    String output = Paths.get(currentDir, "resources", "result.txt").toString();
    static final int N_LINES = 99;
    static final String KEYWORD = "на";

    /**
     * Проверяем, что кол-во записей в файле с результатами совпадает с кол-вом текстовых файлов в директории
     * */
    @Test
    @DisplayName("Number of lines in output file is as expected")
    public void testNumberOfLinesInOutputFileIsAsExpected() {
        MultiThreadedFileSearch.doSearch(dir, output, KEYWORD);
        try (BufferedReader reader = new BufferedReader(new FileReader(output))) {
            int counter = 0;
            while (reader.readLine() != null) {
                ++counter;
            }
            assertEquals(counter, N_LINES);
        } catch (IOException e) {
            fail();
        }
    }

    /**
     * Проверяем структуру файла с результатами -- в каждой записи на определённом месте должно
     * находиться ключевое слово
     * */
    @Test
    @DisplayName("Structure of output file")
    public void testOutputFileStructure() {
        MultiThreadedFileSearch.doSearch(dir, output, KEYWORD);
        try (BufferedReader reader = new BufferedReader(new FileReader(output))) {
            String line;
            while ((line = reader.readLine()) != null) {
                assertEquals(line.split(" ")[2], KEYWORD);
            }
        } catch (IOException e) {
            fail();
        }
    }
}
