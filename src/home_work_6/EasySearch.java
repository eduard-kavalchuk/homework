package home_work_6;

import home_work_6.api.ISearchEngine;

public class EasySearch implements ISearchEngine {
    public long search(String text, String word) {
        return text.indexOf(word);
    }

    public static void main(String[] args) {
        String text = "ad ad mmf pwo r";
        EasySearch es = new EasySearch();
        System.out.println(es.search(text, "mmf1"));
    }
}
