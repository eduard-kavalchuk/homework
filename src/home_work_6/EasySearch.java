package home_work_6;

import home_work_6.api.ISearchEngine;

public class EasySearch implements ISearchEngine {
    // Реализует поиск слова с помощью метода substring
    public long search(String text, String word) {
        int idx;
        long counter = 0;

        if (text.equals(word))
            return 1;

        if (text.indexOf(word + " ") == 0)
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
}
