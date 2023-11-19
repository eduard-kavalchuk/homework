package home_work_5;

import home_work_5.helpers.FileReader;

import java.io.*;

public class Demo {
    private static String[] names;
    public static void main(String[] args) throws IOException {
        home_work_5.helpers.FileReader fr = FileReader.getInstance();
        for (String s : fr.getNames())
            System.out.println(s);

    }

}
