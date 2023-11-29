package home_work_6;

import home_work_6.api.ISearchEngine;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class RegExSearch implements ISearchEngine {
    // ищем отдельно стоящее слово
    public long search(String text, String word) {
        String firstPositionRe = "^" + word + "\\s+";
        String middlePositionRe = "\\s+" + word + "\\s+";
        String endPositionRe = "\\s+" + word + "$";
        String pattern = String.join("|", firstPositionRe, middlePositionRe, endPositionRe);
        Pattern stringPattern = Pattern.compile(pattern);
        Matcher m = stringPattern.matcher(text);
        long counter = 0;
        while (m.find())
            ++counter;
        return counter;
    }

    public static void main(String[] args) {
        String text = "a b ce d ef";
        String word = "ef";
        RegExSearch rs = new RegExSearch();
        System.out.println(rs.search(text, word));
    }
}
