package home_work_5;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Scanner;
import java.util.ArrayList;
import java.util.List;

public class Demo {
    private static String[] names;
    public static void main(String[] args) throws IOException {
        readNamesFromFile("names.txt");
        for (String name : names)
            System.out.println(name);

    }

    public static void readNamesFromFile(String filename) throws IOException {
        if (names == null) {
            String path = String.join(File.separator,
                    System.getProperty("user.dir"), "src", "home_work_5", "files", filename);
            List<String> listOfStrings = new ArrayList<String>();
            listOfStrings = Files.readAllLines(Paths.get(path));
            names = listOfStrings.toArray(new String[0]);


//            String path = String.join(File.separator,
//                    System.getProperty("user.dir"), "src", "home_work_5", "files", filename);
//            File file = new File(path);
//            Scanner sc = new Scanner(file);
//            while (sc.hasNextLine())
//                System.out.println(sc.nextLine());
        }


    }

}
