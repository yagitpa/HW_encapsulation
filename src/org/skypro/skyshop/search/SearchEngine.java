package org.skypro.skyshop.search;

import org.skypro.skyshop.exceptions.BestResultNotFound;

import java.util.ArrayList;
import java.util.List;

public class SearchEngine {
    private final List<Searchable> items = new ArrayList<>();

    public void add(Searchable item) {
        items.add(item);
    }

    public List<Searchable> search(String query) {
        List<Searchable> results = new ArrayList<>();
        String lowerCaseQuery = query.toLowerCase();

        for (Searchable item : items) {
            if (item != null && item.getSearchTerm().toLowerCase().contains(lowerCaseQuery)) {
                results.add(item);
            }
        }
        return results;
    }

    public Searchable findBestResult(String search) throws BestResultNotFound {
        if (search == null || search.isBlank()) {
            throw new IllegalArgumentException("Поисковый запрос не может быть пустым");
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
