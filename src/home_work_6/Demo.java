package home_work_6;

import home_work_6.api.ISearchEngine;

public class Demo {
    public static void main(String[] args) {
        BasicSearch bs = new BasicSearch();
        SearchEnginePunctuationNormalizer o = new SearchEnginePunctuationNormalizer(bs);
        final String doc = o.get(BasicSearch.path);
        ISearchEngine es = new EasySearch();
        ISearchEngine re = new RegExSearch();

        String word = "мир";
        System.out.println(re.search(doc, word));
        System.out.println(es.search(doc, word));
        System.out.println(bs.getWordCount(doc, word));




    }
}
