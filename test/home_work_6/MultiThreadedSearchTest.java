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

    @Test
    @DisplayName("Number of lines in output file is as expected")
    public void testNumberOfLinesInOutputFileIsAsExpected() {
        MultiThreadedFileSearch.doSearch(dir, output, "на");

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
}
