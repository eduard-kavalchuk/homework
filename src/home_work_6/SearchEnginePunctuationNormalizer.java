package home_work_6;

public class SearchEnginePunctuationNormalizer extends BasicSearch {
    private static final String PUNCTUATION_MARKS = "[)(,;:!?'\".]";
    private final BasicSearch bs;
    public SearchEnginePunctuationNormalizer(BasicSearch bs) {
        this.bs = bs;
    }

    // Удаляет из строки нежелательные символы
    public String get(String path) {
        String doc = bs.get(path);
        return  doc
                .replaceAll("\\s[^\\p{IsAlphabetic}\\p{IsDigit}]+\\s", " ") // убрать все слова где нет букв (любого алфавита)
                .replaceAll("^[^\\p{IsAlphabetic}\\p{IsDigit}]+\\s", " ")
                .replaceAll("\\s[^\\p{IsAlphabetic}\\p{IsDigit}]+$", " ")
                .replaceAll(PUNCTUATION_MARKS, " ") // убрать знаки пунктуации
                .trim()  // remote leading and trailing spaces
                .replaceAll("\\s+", " ");  // remove all consecutive escapes
    }
}
