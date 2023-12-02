package home_work_6;

import home_work_6.api.ISearchEngine;

public class CaseInsensitiveSearch implements ISearchEngine {
    final ISearchEngine engine;
    public CaseInsensitiveSearch(ISearchEngine engine) {
        this.engine = engine;
    }

    // Позволяет выполнять поиск слова без учёта регистра.
    // Декорирует объект выполняющий поиск с учётом регистра.
    public long search(String text, String word) {
        return engine.search(text.toLowerCase(), word.toLowerCase());
    }
}
