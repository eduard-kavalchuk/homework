package home_work_5.helpers;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;

/**
 * Provides a file reading method and stores an array of real names
 * */
public class FileReader {
    /**
     * Path to an internal file storing real names that can also be used as nicknames
     * */
    private static final String NAMES_FILE_PATH =
            String.join(File.separator, "src", "home_work_5", "files", "names.txt");

    /**
     * Stores the only instance of this class.
     * */
    private static FileReader fr = null;

    /**
     * Arrays of real names
     * */
    private String[] namesBuffer;

    /**
     * Constructor is private since this class is implemented as a singleton
     * */
    private FileReader(){}

    /**
     * Provides a singleton instance of this class
     * */
    public static FileReader getInstance() {
        if (fr == null) {
            fr = new FileReader();
        }
        return fr;
    }

    /**
     * Returns an array of real names.
     * Upon the first call the array is filled with data stored in file
     * available at {@code NAMES_FILE_PATH}. Subsequent call just return the array.
     * */
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

    /**
     * Returns an array of names fetched from file.
     * @param path path to file of newline-separated strings. Each string is interpreted as name.
     * @return array of names
     * */
    public String[] readNamesFromFile(String path) throws IOException {
        List<String> listOfStrings = Files.readAllLines(Paths.get(path));
        return listOfStrings.toArray(new String[0]);
    }
}
