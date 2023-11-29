package home_work_6;

import home_work_6.api.ISearchEngine;

public class EasySearch implements ISearchEngine {
    public long search(String text, String word) {
        int idx;
        long counter = 0;

        if (text.indexOf(word) == 0)
            ++counter;

        while ((idx = text.indexOf(" " + word + " ")) != -1) {
            ++counter;
            text = text.substring(idx + word.length() + 2);
        }

        text = text.substring(text.length() - word.length());
        if (text.indexOf(word) == 0)
            ++counter;

        return counter;
    }

    public static void main(String[] args) {
        String text = "ef  ef ce ef ef";
        String word = "ef";
        EasySearch es = new EasySearch();
        System.out.println(es.search(text, word));
    }
}
