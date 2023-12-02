package home_work_6;

import home_work_5.Animal;
import home_work_5.AnimalFactory;
import home_work_6.api.ISearchEngine;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class SearchTest {
    static BasicSearch bs = new BasicSearch();
    static ISearchEngine es = new EasySearch();
    static ISearchEngine re = new RegExSearch();
    static ISearchEngine ci = new CaseInsensitiveSearch(es);
    static SearchEnginePunctuationNormalizer o = new SearchEnginePunctuationNormalizer(bs);
    final static String doc = o.get(BasicSearch.path);

    @Test
    @DisplayName("Test equivalence of different search methods")
    public void testSearchMethodsEquality() {
        String[] keywords = new String[]{"и", "И", "мир", "Мир", "война", "Война"};
        for (String word : keywords) {
            assertEquals(re.search(doc, word), es.search(doc, word));
            assertEquals(re.search(doc, word), bs.getWordFrequency(doc, word));
        }
    }

    @Test
    @DisplayName("Test case insensitive search")
    public void testCaseInsensitiveSearch() {
        long n1 = re.search(doc, "война"), n2 = re.search(doc, "Война");
        assertEquals(n1 + n2, ci.search(doc, "Война"));
        assertEquals(n1 + n2, ci.search(doc, "война"));
    }
}
