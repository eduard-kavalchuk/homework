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
        FileReader fr = FileReader.getInstance();
        for (String s : fr.getNames())
            System.out.println(s);

    }

}
