package home_work_6;

public class SearchEnginePunctuationNormalizer extends BasicSearch {
    private static final String PUNCTUATION_MARKS = "[.,;:!?\'\"]";
    private final BasicSearch bs;
    public SearchEnginePunctuationNormalizer(BasicSearch bs) {
        this.bs = bs;
    }
    public String get(String path) {
        String doc = bs.get(path);
        return  doc
                .replaceAll("\\s[^\\p{L}]+\\s", " ") // убрать все слова где нет букв (любого алфавита)
                .replaceAll(PUNCTUATION_MARKS, " ") // убрать знаки пунктуации
                .trim()  // remote leading and trailing spaces
                .replaceAll("\\s+", " ");  // remove all consecutive escapes
    }

    public static void main(String[] args) {
        SearchEnginePunctuationNormalizer o = new SearchEnginePunctuationNormalizer(new BasicSearch());
        String doc = o.get(BasicSearch.path);
//        System.out.println(doc.substring(20000, 20200));
//        System.out.println(o.getUniqueWordsNumber(doc));
//        o.printMostUsedWords(doc, 20);
        System.out.println(o.getWordCount(doc, "И"));
    }
}
