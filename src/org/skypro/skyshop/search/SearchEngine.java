package org.skypro.skyshop.search;

import org.skypro.skyshop.exceptions.BestResultNotFound;

public class SearchEngine {
    private final Searchable[] items;
    private int currentIndex = 0;

    public SearchEngine(int size) {
        this.items = new Searchable[size];
    }

    public void add(Searchable item) {
        if (currentIndex < items.length) {
            items[currentIndex++] = item;
        } else {
            System.out.println("Больше нельзя добавить элементов");
        }
    }

    public Searchable[] search(String query) {
        Searchable[] results = new Searchable[5];
        int resultIndex = 0;
        String lowerCaseQuery = query.toLowerCase();

        for (Searchable item : items) {
            if (item != null && item.getSearchTerm().toLowerCase().contains(lowerCaseQuery)) {
                results[resultIndex++] = item;
            }
            if (resultIndex == results.length) {
                break;
            }
        }
        return results;
    }

    public Searchable findBestResult(String search) throws BestResultNotFound {
        if (search == null || search.isBlank()) {
            throw new IllegalArgumentException("Поисовый запрос не может быть пустым");
        }

        Searchable bestResult = null;
        int maxOccurrences = 0;

        for (Searchable item : items) {
            if (item == null) {
                continue;
            }
            int occurrences = countOccurrences(item.getSearchTerm(), search);
            if (occurrences > maxOccurrences) {
                maxOccurrences = occurrences;
                bestResult = item;
            }
        }

        if (bestResult == null) {
            throw new BestResultNotFound("По Вашему запросу \"" + search + "\" ничего не найдено");
        }
        return bestResult;
    }

    private int countOccurrences(String source, String target) {
        int count = 0;
        int index =0;
        while ((index = source.indexOf(target, index)) != -1) {
            count++;
            index += target.length();
        }
        return count;
    }
}
