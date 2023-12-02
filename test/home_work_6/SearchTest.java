package home_work_6;

import home_work_6.api.ISearchEngine;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

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

    @Test
    @DisplayName("привет, как дела!")
    public void test1() {
        String doc = "привет, как дела!";
        SearchEnginePunctuationNormalizer o2 = new SearchEnginePunctuationNormalizer(bs);
        String normalized = o2.get(doc);
        assertEquals(1, re.search(normalized, "привет"));
        assertEquals(1, re.search(normalized, "как"));
        assertEquals(1, re.search(normalized, "дела"));

        assertEquals(3, bs.getUniqueWordsCount(normalized));
        assertEquals(0, re.search(normalized, "Привет"));
    }

    @Test
    @DisplayName("привет,какдела!")
    public void test2() {
        String doc = "привет,какдела!";
        SearchEnginePunctuationNormalizer o2 = new SearchEnginePunctuationNormalizer(bs);
        String normalized = o2.get(doc);
        assertEquals(1, re.search(normalized, "привет"));
        assertEquals(0, re.search(normalized, "как"));
        assertEquals(0, re.search(normalized, "дела"));
        assertEquals(1, re.search(normalized, "какдела"));
        assertEquals(0, re.search(normalized, "какдела!"));

        assertEquals(2, bs.getUniqueWordsCount(normalized));
    }

    @Test
    @DisplayName("привет;какдела!")
    public void test3() {
        String doc = "привет;какдела!";
        SearchEnginePunctuationNormalizer o2 = new SearchEnginePunctuationNormalizer(bs);
        String normalized = o2.get(doc);
        assertEquals(1, re.search(normalized, "привет"));
        assertEquals(0, re.search(normalized, "как"));
        assertEquals(0, re.search(normalized, "дела"));
        assertEquals(1, re.search(normalized, "какдела"));
        assertEquals(0, re.search(normalized, "какдела!"));

        assertEquals(2, bs.getUniqueWordsCount(normalized));
    }

    @Test
    @DisplayName("как дела!.Что делаешь?")
    public void test4() {
        String doc = "как дела!.Что делаешь?";
        SearchEnginePunctuationNormalizer o2 = new SearchEnginePunctuationNormalizer(bs);
        String normalized = o2.get(doc);
        assertEquals(4, bs.getUniqueWordsCount(normalized));
    }

    @Test
    @DisplayName("Привет-привет")
    public void test5() {
        String doc = "Привет-привет";
        SearchEnginePunctuationNormalizer o2 = new SearchEnginePunctuationNormalizer(bs);
        String normalized = o2.get(doc);
        assertEquals(1, bs.getUniqueWordsCount(normalized));
        assertEquals(0, re.search(normalized, "привет"));
        assertEquals(0, re.search(normalized, "Привет"));
    }

    @Test
    @DisplayName("Привет -привет")
    public void test6() {
        String doc = "Привет -привет";
        SearchEnginePunctuationNormalizer o2 = new SearchEnginePunctuationNormalizer(bs);
        String normalized = o2.get(doc);
        assertEquals(2, bs.getUniqueWordsCount(normalized));
        assertEquals(1, re.search(normalized, "Привет"));
        assertEquals(0, re.search(normalized, "Привет "));
        assertEquals(0, re.search(normalized, " Привет"));
        assertEquals(1, re.search(normalized, "-привет"));
        assertEquals(0, re.search(normalized, "привет"));
    }

    @Test
    @DisplayName("4-х")
    public void test7() {
        String doc = "4-х";
        SearchEnginePunctuationNormalizer o2 = new SearchEnginePunctuationNormalizer(bs);
        String normalized = o2.get(doc);
        assertEquals(1, bs.getUniqueWordsCount(normalized));
    }

    @Test
    @DisplayName("один и 1")
    public void test8() {
        String doc = "один и 1 ";
        SearchEnginePunctuationNormalizer o2 = new SearchEnginePunctuationNormalizer(bs);
        String normalized = o2.get(doc);
        assertEquals(2, bs.getUniqueWordsCount(normalized));
    }

    @Test
    @DisplayName("бабушка бабушке бабушку")
    public void test9() {
        String doc = "бабушка бабушке бабушку";
        SearchEnginePunctuationNormalizer o2 = new SearchEnginePunctuationNormalizer(bs);
        String normalized = o2.get(doc);
        assertEquals(3, bs.getUniqueWordsCount(normalized));
        assertEquals(1, re.search(normalized, "бабушка"));
        assertEquals(1, re.search(normalized, "бабушке"));
        assertEquals(1, re.search(normalized, "бабушку"));
    }

}
