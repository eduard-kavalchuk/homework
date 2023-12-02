package home_work_6;

import home_work_6.api.ISearchEngine;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class RegExSearch implements ISearchEngine {
    // Реализует поиск слова с помощью регулярных выражений
    public long search(String text, String word) {
        String start = "^" + word + " ";
        String middle = " " + word + " ";
        String end = " " + word + "$";
        String pattern = String.join("|", start, middle, end);
        Pattern stringPattern = Pattern.compile(pattern);
        Matcher m = stringPattern.matcher(text);
        long counter = 0;
        while (m.find()) {
            ++counter;
        }
        return counter;
    }
}
