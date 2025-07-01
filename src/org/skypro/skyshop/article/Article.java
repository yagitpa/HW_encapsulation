package org.skypro.skyshop.article;

import org.skypro.skyshop.search.Searchable;

public final class Article implements Searchable {

    private final String title;
    private final String text;

    public Article(String title, String text) {
        if (title == null || title.trim().isEmpty()) {
            throw new IllegalArgumentException("Название статьи не может быть пустым");
        }
        if (text == null || text.trim().isEmpty()) {
            throw new IllegalArgumentException("Текст статьи не может быть пустым");
        }
        this.title = title;
        this.text = text;
    }

    @Override
    public String getSearchTerm() {
        return toString();
    }

    @Override
    public String getContentType() {
        return "ARTICLE";
    }

    @Override
    public String getName() {
        return title + ": " + text;
    }

    public String getTitle() {
        return title;
    }

    public String getText() {
        return text;
    }

    @Override
    public String toString() {
        return title + "\n" + text;
    }
}
