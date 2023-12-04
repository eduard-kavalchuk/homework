package home_work_6;

import home_work_6.api.ISearchEngine;

public class Demo {
    public static void main(String[] args) {
        BasicSearch bs = new BasicSearch();
        ISearchEngine es = new EasySearch();
        ISearchEngine re = new RegExSearch();
        ISearchEngine ci = new CaseInsensitiveSearch(es);
        SearchEnginePunctuationNormalizer o = new SearchEnginePunctuationNormalizer(bs);
        final String doc = o.get(BasicSearch.path);

        String[] keywords = new String[]{"Я", "я"};
        for (String word : keywords) {
            System.out.println("RegExSearch: " + re.search(doc, word));
            System.out.println("EasySearch: " + es.search(doc, word));
            System.out.println("BasicSearch: " + bs.getWordFrequency(doc, word));
            System.out.println("CaseInsensitiveSearch: " + ci.search(doc, word));
        }
    }
}
