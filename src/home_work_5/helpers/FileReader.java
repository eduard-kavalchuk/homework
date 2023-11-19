package home_work_5.helpers;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;

public class FileReader {
    private static final String NAMES_FILE_PATH =
            String.join(File.separator, "src", "home_work_5", "files", "names.txt");
    private static FileReader fr = null;
    private String[] namesBuffer;
    private FileReader(){}
    public static FileReader getInstance() {
        if (fr == null) {
            fr = new FileReader();
        }
        return fr;
    }
    public String[] getNames() {
        if (namesBuffer == null) {
            try {
                namesBuffer = readNamesFromFile(NAMES_FILE_PATH);
            } catch (IOException e) {
                System.out.println("No such file: " + NAMES_FILE_PATH );
                System.exit(1);
            }
        }
        return namesBuffer;
    }
    public String[] readNamesFromFile(String path) throws IOException {
        List<String> listOfStrings = Files.readAllLines(Paths.get(path));
        return listOfStrings.toArray(new String[0]);
    }
}
