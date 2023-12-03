package home_work_6;

import java.io.*;

public class Util {
    public static String src = String.join(File.separator, System.getProperty("user.dir"), "resources", "book.txt");
    public static String dst = String.join(File.separator, System.getProperty("user.dir"), "resources", "books");

    public static void copyFile(String src, String dest, int start, int n_lines) {
        try (BufferedReader reader = new BufferedReader(new FileReader(src));
             BufferedWriter writer = new BufferedWriter(new FileWriter(dest))) {
            String line;
            int i = 0;
            while ((line = reader.readLine()) != null && i < start + n_lines) {
                if (++i < start) continue;
                writer.write(line + "\n");
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public static void main(String[] args) throws IOException {
        for (int i = 1; i < 3; i++) {
            String dst = String.join(File.separator, Util.dst, i + ".txt");
            copyFile(Util.src, dst, 100 * i, 100);
        }

    }
}
